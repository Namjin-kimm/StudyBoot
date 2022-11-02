package com.iu.home.config;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	//public을 선언하면 default로 바꾸라는 메세지가 뜬다
	WebSecurityCustomizer webSecurityConfig() {
		//Security에서 무시해야하는 URL 패턴 등록
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception {
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()
//					.antMatchers("/").permitAll()
//					.antMatchers("/login").permitAll()
//					.antMatchers("/logout").permitAll()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.antMatchers("/qna/list").permitAll()
					.antMatchers("/qna/**").hasRole("MEMBER")
//					.anyRequest().authenticated()
					.anyRequest().permitAll()
					.and()
//				httpSecurity.formLogin()
				.formLogin()		//로그인 폼 인증 설정
					.loginPage("/member/login") //내장된 로그인폼을 사용하지 않고 개발자가 만든 폼요청 URL
//					.loginProcessingUrl("login")	//로그인을 진행할 form 태그의 action의 주소 지정, 필수는 아님
					.passwordParameter("pw")	//패스워드 파라미터는 password이지만, 개발자가 다른 파라미터 이름을 사용할 때
					.usernameParameter("id")	//id 파라미터는 username이지만, 개발자가 다른 파라미터 이름을 사용할 때
					.defaultSuccessUrl("/")		//인증에 성공할 경우 요청할 URL
					.failureUrl("/member/login")//인증에 실패했을 경우 요청할 URL
					.permitAll()
					.and()
				.logout()
					.permitAll();
		return httpSecurity.build();
	}

}
