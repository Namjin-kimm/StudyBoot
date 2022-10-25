package com.iu.home.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String email;
	private String name;
	private boolean enabled;
	private List<RoleVO> roleVOs;

}
