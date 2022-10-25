package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public int setJoin(MemberVO memberVO)throws Exception{
		int result = 0;
		int result1 = memberMapper.setJoin(memberVO);
		int result2 = memberMapper.setJoinRole(memberVO);
		if(result1 == 1 && result2 ==1) {
			result = 1;
		}
		return result;
		
	}
	
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}

}
