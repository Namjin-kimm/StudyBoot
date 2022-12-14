package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogoutSuccessCustom implements LogoutSuccessHandler{
	
	@Value("${my.restAPI.key}")
	private String restAPI;
	
	@Value("${my.redirect.uri}")
	private String redirectURI;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		MemberVO memberVO = (MemberVO)authentication.getPrincipal(); //memberVO
		String social = memberVO.getSocial();
		if(social != null) {
			if(social.equals("kakao")) {
				
				//https://developers.kakao.com/logout
			response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=" + restAPI + "&logout_redirect_uri=" + redirectURI);
//				RestTemplate restTemplate = new RestTemplate();
//				
//				MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//				map.add("client_id", "e757baf49d3cb7d82e62726cdcd7b177");
//				
//				HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(map);
////			header XX
////			parameter XX
//				log.info("kakao Logout");
//				ResponseEntity<String> res = restTemplate.getForEntity("https://developers.kakao.com/logout", null, String.class);
//				log.info("res => {}", res);
//				response.sendRedirect("/");
			}else if(social.equals("google")) {
				
			}else {
				
			}
				
			
		log.info("=== logout ??????????????? ??????");
		
		}else {
			response.sendRedirect("/");
			
		}

	}
}
