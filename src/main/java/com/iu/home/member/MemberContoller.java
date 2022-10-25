package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberContoller {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원가입
	@GetMapping("join")
	public void join()throws Exception{
		
	}
	
	@PostMapping("join")
	public String join(MemberVO memberVO)throws Exception{
		memberService.setJoin(memberVO);
		return "redirect:./login";
	}
	
	@GetMapping("login")
	public void login()throws Exception{
		
	}
	
	// 로그인
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		return "redirect:/";
		}

}
