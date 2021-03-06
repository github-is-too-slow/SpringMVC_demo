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
    //指定请求方式为get
    @RequestMapping(value = "/user/name/some.do")
    public ModelAndView doSome(String username, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", username);
        mv.addObject("age", age);
        mv.setViewName("forward:/view/show.jsp");
        return mv;
    }
}
