package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberService {
	
	@Value("${social.kakao.admin}")
	private String adminKey;
	
	@Autowired
	private MemberMapper memberMapper;
	
	public int setDelete(MemberVO memberVO) throws Exception {
	      //1. WebClient 생성
	      WebClient webClient = WebClient.builder()
	                              		 .baseUrl("https://kapi.kakao.com/")
	                              		 .build();
	      
	      //2. parameter
	      MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
	      map.add("target_id_type", "user_id");
	      map.add("target_id", memberVO.getId());
	      
	      Mono<String> res = webClient.post()
	             .uri("v1/user/unlink")
	             .body(BodyInserters.fromFormData(map))
	             .header("Authorization","KakaoAK "+adminKey)
	             .header("Content-Type: application/x-www-form-urlencoded")
	             .retrieve()
	             .bodyToMono(String.class);
	      
	      log.info("WebClientResult -> {}",res.block());
	             return 1;
	   }
	
	public int setDelete2(MemberVO memberVO)throws Exception{
		int result =0;
		RestTemplate restTemplate = new RestTemplate();
		
		//--Header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); //application/x-www-form-urlencoded
		headers.add("Authorization","KakaoAK " + adminKey);
		
		//--parameter
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");	// -d "target_id_type=user_id" 
		params.add("target_id", memberVO.getId()); // -d "target_id=123456789" 

		//--요청 객체
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(params,headers);
		
		//--전송 후 결과 처리
		ResponseEntity<String> res	= restTemplate.postForEntity("https://kapi.kakao.com/v1/user/unlink", req, String.class);
		
		log.info("res => {}", res.getBody());
		
		if(res.getBody() != null) {
			result =1;
		}
		
		return result;
	}
	
	//사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check = false;
		//check = false : 검증 성공(error 없음)
		//check = true  : 검증 실패(error 있음)
		
		//1. annotation 검증
		check = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check = true;
			//에러메세지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의 key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
		}
		
		//3. id가 중복인지 검증
		if(memberMapper.getIdCheck(memberVO.getId()) > 0) {
			check = true;
			bindingResult.rejectValue("id", "member.id.duplicate");
		}
		
		return check;
	}
	
	public int setJoin(MemberVO memberVO)throws Exception{
		int result = 0;
		int result1 = memberMapper.setJoin(memberVO);
		
		int result2 = memberMapper.setJoinRole(memberVO);
		if(result1 < 1 || result2 < 1) {
			throw new Exception();
		}
		if(result1 == 1 && result2 ==1) {
			result = 1;
		}
		return result;
		
	}
	
//	이제 로그인 처리는 Security에서 한다
//	public MemberVO getLogin(MemberVO memberVO)throws Exception{
//		return memberMapper.getLogin(memberVO);
//	}
	
	public Long getIdCheck(String id)throws Exception{
		Long result = memberMapper.getIdCheck(id);
		return result;
	}

}
