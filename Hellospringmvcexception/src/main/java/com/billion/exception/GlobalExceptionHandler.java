package com.billion.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Billion
 * @create 2021-03-06 12:46
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = NameException.class)
	public ModelAndView handlerNameException(UserException excption){
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", excption);
		mv.setViewName("forward:/WEB-INF/view/nameerror.jsp");
		return mv;
	}

	@ExceptionHandler(value = AgeException.class)
	public ModelAndView handlerAgeException(UserException excption){
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", excption);
		mv.setViewName("forward:/WEB-INF/view/ageerror.jsp");
		return mv;
	}

	@ExceptionHandler
	public ModelAndView handlerOtherException(UserException excption){
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", excption);
		mv.setViewName("forward:/WEB-INF/view/others.jsp");
		return mv;
	}
}
