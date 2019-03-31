package org.hut.config;

import org.hut.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer{
	
	/**
	 * 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index.html").setViewName("index");
	}
	
	/**
	 * 	注册登录拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] excludePathPatterns = {"/","/index.html",
										"/customerLogin","/checkCusMobilePhone",
										"/phoneCode","/customerRegister",
										"/sessionCustomer","/show",
										"/pro","/proDetail",
										/* 静态资源放行 */
										"/static/**","/base/**",
										"/css/**","/fonts/**",
										"/images/**","/js/**"};
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
			.excludePathPatterns(excludePathPatterns);
	}
}
