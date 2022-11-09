package com.iu.home.member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		
		
		String social = userRequest.getClientRegistration().getRegistrationId();
		log.info("Social => {}",social);
		
//		if(social.equals("kakao")) {
		OAuth2User auth2User = this.socialJoinCheck(userRequest);
		return auth2User;
//		}
		
		
//		return auth2User;
	}
	
	private OAuth2User socialJoinCheck(OAuth2UserRequest userRequest){
		OAuth2User auth2User = super.loadUser(userRequest);
		log.info("============== 사용자 정보 ==============");
		log.info("Name => {}", auth2User.getName());  //사용자의 고유 id
		log.info("Attr => {}",auth2User.getAttributes()); //사용자의 고유 id, 연결날짜, 프로필 등 properties라는 키 안에 오브젝트 객체가 담긴 것
		log.info("Auth => {}",auth2User.getAuthorities()); //사용자의 권한 정보
		//회원가입 유무 판단, 처음온 사람이면 회원가입 진행, 아니면 else
		
		Map<String, Object> map = auth2User.getAttributes();
		
		// map에서 key들을 꺼내는 작업
		Iterator<String> keys = map.keySet().iterator();
		//몇개가 있는지 모를때는 	while
		while(keys.hasNext()) {
			String key = keys.next();
			log.info("Key : {}", key);
			
		}
		Map<String, String> lm = auth2User.getAttribute("properties");
		Map<String, Object> ka = auth2User.getAttribute("kakao-account");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(auth2User.getName());
		
		//pw가 없으므로 비워두거나 랜덤한 값으로 생성
		//memberVO.setPw(null);
		memberVO.setName(lm.get("nickname"));
//		memberVO.setEmail(ka.get("email").toString());
		
		memberVO.setSocial(userRequest.getClientRegistration().getRegistrationId());
		memberVO.setAttributes(auth2User.getAttributes());
		
		//Role/권한 지금은 임의로 작성, 나중에는 DB에 있는것 조회해야함
		List<RoleVO> list = new ArrayList<>();
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleName("ROLE_MEMBER");
		list.add(roleVO);
		
		memberVO.setRoleVOs(list);
		
		
		
		return memberVO;
	}

}
