package com.iu.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data
public class MemberVO implements UserDetails, OAuth2User{
	
	@NotBlank(message = "ID쓸래 나랑 죽을래!!!")
	private String id;
	@NotBlank
	@Size(max = 12, min = 6)
//	@Pattern(regexp = "")
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
	
	//======== Social Login ==========
	//Kakao, Naver, Google
	private String social;
	
	//OAuth2User, Token등 정보 저장
	private Map<String, Object> attributes;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// <? super T>
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}
	@Override
	public String getPassword() {
		// pw 반환
		return this.getPw();
	}
	@Override
	public String getUsername() {
		// id 반환
		return this.getId();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		//계정의 만료 여부
		//true : 만료 안됨
		//false: 만료 됨, 로그인 불가
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부
		// true : 계정이 잠기지 않음
		// false: 계정이 잠김, 로그인 불가
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		// true : 만료가 안됨
		//false : 만료됨,로그인 안됨
		return	true;
	}
	
	//isEnabled
	//계정 사용 여부
	// true : 계정 활성화(계정 사용 가능)
	// false: 계정 비활성화(계정 사용 불가, 로그인 불)
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return this.attributes;
	}
	
	

}
