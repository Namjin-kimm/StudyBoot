package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberContoller {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String [] ar)throws Exception{
		log.info("=========================");
		log.info("ID : {}", memberVO.getId());
		log.info("Name : {}", memberVO.getName());
		for(String s : ar) {
			log.info(s);
		}
		return memberVO;
	}
	
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
	
	@GetMapping("idCheck")
	@ResponseBody
	public Long getIdCheck(String id)throws Exception{
		Long result = memberService.getIdCheck(id);
		
//		if(result ==0) {
//			throw new Exception("테스트야 이 쉐키야!!");
//		}
		return result;
	}

}
