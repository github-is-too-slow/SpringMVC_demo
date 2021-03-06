package com.billion.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Billion
 * @create 2021-03-06 15:02
 */
public class MyInterceptor implements HandlerInterceptor{
	/**
	 * 在处理器方法执行前执行
	 * @param request
	 * @param response
	 * @param handler 被拦截的处理器对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response,
	                         Object handler) throws Exception {
		String username = "";
		Object obj = request.getSession().getAttribute("username");
		if(null != obj){
			username = (String) obj;
		}
		if(!"zhangsan".equals(username)){
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			return false;
		}
		return true;
	}

	/**
	 * 在处理器方法执行后执行
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView 处理器方法执行返回的视图
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request,
	                       HttpServletResponse response,
	                       Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
