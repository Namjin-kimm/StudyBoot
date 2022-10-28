package com.iu.home.member;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank(message = "ID쓸래 나랑 죽을래!!!")
	private String id;
	@NotBlank
	@Size(max = 12, min = 6)
	private String pw;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String name;
	@Range(max = 150, min = 0)
	private int age;
	@Past
	private Date birth;
	private String pwCheck;
	private boolean enabled;
	private List<RoleVO> roleVOs;

}
