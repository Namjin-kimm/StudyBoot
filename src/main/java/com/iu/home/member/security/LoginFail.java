package com.iu.home.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("======= Login Fail =======");
		log.info("ClassName => {}", exception.getClass().toString());
		log.info("LocalMessage => {}", exception.getLocalizedMessage());
		log.info("Cause => {}", exception.getCause());
		log.info("Message => {}", exception.getMessage());
//		String name = exception.getClass().toString();
//		name = name.substring(name.lastIndexOf(".") + 1);
//		if(name.equals("BadCredentialsException")) {
//			name = "비번 틀림";
//		}
		
		//참조변수명 instanceOf 클래스명
		String result = null;
		if(exception instanceof BadCredentialsException) {
			//위에 서브스트링해서 한 방법이랑 동일한 방법 : instanceOf
			result = "비번 틀림";
		}else if(exception instanceof InternalAuthenticationServiceException) {
			result = "없는 ID";
		}else {
			result = "로그인 실패";
		}
		
//		3가지 방법
		
//		redirect
//		result = URLEncoder.encode(result, "UTF-8");
//		response.sendRedirect("/member/login?error=true&message="+result);
		
		//JSP를 바로 찾아감
		request.setAttribute("msg", result);
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
//		Controller로 POST 방식으로 보내는 것
//		request.setAttribute("msg", result);
//		request.getRequestDispatcher("/member/login").forward(request, response);
		
		
	}
	
	

}
