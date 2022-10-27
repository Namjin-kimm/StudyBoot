package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
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
	
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
	public Long getIdCheck(String id)throws Exception{
		Long result = memberMapper.getIdCheck(id);
		return result;
	}

}
