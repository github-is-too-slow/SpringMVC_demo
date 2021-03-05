package com.billion.controller;

import com.billion.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.media.SubtitleTrack;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Billion
 * @create 2021/02/27 21:57
 */
@Controller  //控制器对象，放入到SpringMVC容器中
@RequestMapping(value = "/user")
public class MyController {
    //指定视图名称
    @RequestMapping(value = "/return1.do")
    public String doReceive1(HttpServletRequest request, String username, Integer age){
        request.setAttribute("username", username);
        request.setAttribute("age", age);
        return "receive";
    }

    //指定视图完整路径
    @RequestMapping(value = "/return2.do")
    public String doReceive2(HttpServletRequest request, String username, Integer age){
        request.setAttribute("username", username);
        request.setAttribute("age", age);
        return "/WEB-INF/view/receive.jsp";
    }

    //通过返回void响应Ajax请求
    @RequestMapping(value = "/ajax.do")
    public void doReceive3(HttpServletResponse response, String username, Integer age) throws IOException {
        //调用service层方法返回Student对象
        Student student = new Student();
        student.setUsername(username);
        student.setAge(age);
        System.out.println(student);

        //转化为json对象
        ObjectMapper om = new ObjectMapper();
        String json = "";
        if(null != student){
            json = om.writeValueAsString(student);
        }
        System.out.println(json);

        //响应json格式数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(json);
        pw.flush();
        pw.close();
    }

    //通过返回Object响应Ajax请求
    @RequestMapping(value = "/objectajax.do")
    @ResponseBody //将转换后的json字符串写入Response对象中响应给浏览器
    public Student doReceive4(HttpServletResponse response, String username, Integer age) throws IOException {
        //调用service层方法返回Student对象
        Student student = new Student();
        student.setUsername(username);
        student.setAge(age);
        System.out.println(student);
        return student;
    }

    //通过返回List集合响应Ajax请求
    @RequestMapping(value = "/objectajaxArray.do")
    @ResponseBody //将转换后的json字符串写入Response对象中响应给浏览器
    public List<Student> doReceive5(HttpServletResponse response, String username, Integer age) throws IOException {
        //调用service层方法返回Student对象
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setUsername(username);
        stu1.setAge(age);
        Student stu2 = new Student();
        stu2.setUsername("李四同学");
        stu2.setAge(25);
        students.add(stu1);
        students.add(stu2);
        return students;
    }

    //通过返回String响应Ajax请求
    //StringHttpMessageConverter默认使用ISO-8859-1编码，produces属性改变其编码
    @RequestMapping(value = "/objectajaxString.do", produces = "text/plain;charset=utf-8")
    @ResponseBody //将转换后的json字符串写入Response对象中响应给浏览器
    public String doReceive6(HttpServletResponse response, String username, Integer age) throws IOException {
        //调用service层方法返回Student对象
        String msg = "欢迎使用SpringMVC开发项目！";
        return msg;
    }
}
