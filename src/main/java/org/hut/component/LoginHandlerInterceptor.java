package org.hut.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hut.pojo.Customer;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor{
	
	/**
	 * 登录验证拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		Customer customer = (Customer) request.getSession().getAttribute("customer");
//		System.out.println("----------------------------");
//		System.out.println(customer);
//		if(customer == null) {
//			request.getRequestDispatcher("/index.html").forward(request, response);
//			return false;
//		}else {
			return true;
//		}
	}
}
