package com.billion.controller;

import com.billion.vo.Student;
import javafx.scene.media.SubtitleTrack;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Billion
 * @create 2021/02/27 21:57
 */
//RequestMapping定义在类上面，
//其value值代表类中所有方法的RequestMapping注解的value中URI的公共前缀部分，称为模块名称
@Controller  //控制器对象，放入到SpringMVC容器中
@RequestMapping(value = "/user")
public class MyController {
    //指定请求方式为get
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC开发Web项目:" + request.getParameter("username"));
        mv.addObject("fun", "使用doSome()方法处理请求");
        mv.setViewName("show");
        return mv;
    }

    //指定请求方式为post
    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC开发Web项目");
        mv.addObject("fun", "使用doOther()方法处理请求");
        mv.setViewName("other");
        return mv;
    }

    //不指定请求方式，任何请求方式均可以
    @RequestMapping(value = "/receive1.do")
    public ModelAndView doReceive1(String username, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.addObject("age", age);
        mv.setViewName("receive");
        return mv;
    }

    //解决请求参数名和形参名不一致问题
    @RequestMapping(value = "/receive2.do")
    public ModelAndView doReceive2(@RequestParam(value = "rusername", required = false) String username,
                                  @RequestParam(value = "rage", required = false) Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.addObject("age", age);
        mv.setViewName("receive");
        return mv;
    }

    //解决请求参数名和形参名不一致问题
    @RequestMapping(value = "/receive3.do")
    public ModelAndView doReceive3(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", student.getUserame());
        mv.addObject("age", student.getAge());
        mv.setViewName("receive");
        return mv;
    }
}
