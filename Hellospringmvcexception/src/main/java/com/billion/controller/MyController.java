package com.billion.controller;

import com.billion.exception.AgeException;
import com.billion.exception.NameException;
import com.billion.exception.UserException;
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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String username, Integer age) throws UserException {
        ModelAndView mv = new ModelAndView();
        if(!("zhangsan".equals(username))){
            throw new NameException("姓名必须为zhangsan");
        }
        if(age != 20){
            throw new AgeException("年龄必须为20岁");
        }
        mv.addObject("name", username);
        mv.addObject("age", age);
        mv.setViewName("show");
        return mv;
    }
}
