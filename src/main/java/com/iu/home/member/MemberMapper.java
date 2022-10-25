package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	// 회원가입시 등급 부여
	public int setJoinRole(MemberVO memberVO)throws Exception;
	
	//회원가입
	public int setJoin(MemberVO memberVO)throws Exception;
	
	// 로그인
	public MemberVO getLogin(MemberVO memberVO)throws Exception;

}
