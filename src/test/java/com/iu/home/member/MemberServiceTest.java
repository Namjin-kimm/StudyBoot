package com.iu.home.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iu.home.member.MemberMapper;
import com.iu.home.member.MemberVO;

@SpringBootTest
class MemberServiceTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void test()throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("manager1");
		memberVO.setPw(passwordEncoder.encode("manager1"));
		memberVO.setName("manager");
		memberVO.setEmail("manager01@gmail.com");
		int result = memberMapper.setJoin(memberVO);
		assertEquals(1, result);
	}

}
