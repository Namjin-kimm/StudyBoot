package com.iu.home.member;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSocialService extends DefaultOAuth2UserService{
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("======= Social Login 시도 =========");
		log.info("UserRequest {}", userRequest);
		log.info("ClientRegistration {}", userRequest.getClientRegistration());
		log.info("AccessToken {}", userRequest.getAccessToken());
		log.info("AdditionalParameters {}", userRequest.getAdditionalParameters());
		log.info("Class {}", userRequest.getClass());
		
		OAuth2User auth2User = super.loadUser(userRequest);
		log.info("============== 사용자 정보 ==============");
		log.info("Name => {}", auth2User.getName());  //사용자의 고유 id
		log.info("Attr => {}",auth2User.getAttributes()); //사용자의 고유 id, 연결날짜, 프로필 등 properties라는 키 안에 오브젝트 객체가 담긴 것
		log.info("Auth => {}",auth2User.getAuthorities()); //사용자의 권한 정보
		
		return null;
	}
	
	private OAuth2User socialJoinCheck(OAuth2UserRequest userRequest)throws Exception{
		//회원가입 유무 판단, 처음온 사람이면 회원가입 진행, 아니면 else
		
	}

}
