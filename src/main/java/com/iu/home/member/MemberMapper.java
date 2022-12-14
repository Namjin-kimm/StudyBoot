package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {
	
	// 아이디 중복확인
	public Long getIdCheck(String id)throws Exception;
	
	// 회원가입시 등급 부여
	public int setJoinRole(MemberVO memberVO)throws Exception;
	
	//회원가입
	public int setJoin(MemberVO memberVO)throws Exception;
	
	// 로그인
	public MemberVO getLogin(String username)throws UsernameNotFoundException;

}
