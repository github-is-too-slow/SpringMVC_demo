package com.billion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Billion
 * @create 2021/02/27 21:57
 */
@Controller  //控制器对象，放入到SpringMVC容器中
public class MyController {
    //控制器方法，返回类型Model代表响应数据，View代表视图(jsp)
    @RequestMapping(value = {"/some.do", "/first.do"})
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC开发Web项目");
        mv.addObject("fun", "使用doSome()方法处理请求");
        //设置返回的视图，只写逻辑名称（文件名），视图解析器会通过字符串拼接成完整路径
        mv.setViewName("show");
        return mv;
        //doSome()方法执行后，会调用Request.setAttribute()方法将mv对象中的数据放入Request域中
        //再调用Request.getDispatcher("/show.jsp").forword()转发页面
    }

    //控制器方法，返回类型Model代表响应数据，View代表视图(jsp)
    @RequestMapping(value = {"/other.do", "/second.do"})
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC开发Web项目");
        mv.addObject("fun", "使用doOther()方法处理请求");
        //设置返回的视图，只写逻辑名称（文件名），视图解析器会通过字符串拼接成完整路径
        mv.setViewName("ohter");
        return mv;
    }
}
