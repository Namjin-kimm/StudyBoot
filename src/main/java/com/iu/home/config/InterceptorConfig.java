package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptors;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	@Autowired //IOC(Inversion Of Control)
	private TestInterceptors testInterceptors;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//method 체이닝
		//적용할 Interceptor 등록
		registry.addInterceptor(testInterceptors)
		//Interceptor에 적용할 url 추가 및 제외
				.addPathPatterns("/qna/**")
				.addPathPatterns("/notice/**")
		//제외할 URL등록
				.excludePathPatterns("/qna/detail")
				.excludePathPatterns("/qna/write");
		
		registry.addInterceptor(studyInterceptor)
				.addPathPatterns("/qna/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
