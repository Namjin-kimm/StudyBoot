package com.iu.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
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
	public void join(@ModelAttribute MemberVO memberVO)throws Exception{
//		MemberVO memberVO = new MemberVO();
//		model.addAttribute(memberVO);
	}
	
	@PostMapping("join")
	public ModelAndView join(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult)throws Exception{
		
//	if(bindingResult.hasErrors()) {
//		//검증에 실패하면 회원가입하는 jsp로 forward
//		log.info("------------- 검증 에러 발생 -------------");
//		mv.setViewName("member/join");
//		return mv;
//	}
	
	boolean check = memberService.getMemberError(memberVO, bindingResult);
	if(check) {
		log.info("------------- 검증 에러 발생 -------------");
		mv.setViewName("member/join");
		//===========================
		List<FieldError> errors = bindingResult.getFieldErrors();
		
		for(FieldError fieldError:errors) {
			log.info("FiledError {}", fieldError);
			log.info("Field = {}", fieldError.getField());
			log.info("Message = {}", fieldError.getRejectedValue());
			log.info("Default = {}", fieldError.getDefaultMessage());
			log.info("Code = {}", fieldError.getCode());
			mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
			
			log.info("=====================================");
		}
		
		
		
		
		
		
		return mv;
	}
		
//		memberService.setJoin(memberVO);
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("login")
	public void login()throws Exception{
		
	}
	
	// 로그인
//	@PostMapping("login")
//	public String login(MemberVO memberVO, HttpSession session)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		memberVO = memberService.getLogin(memberVO);
//		session.setAttribute("member", memberVO);
//		return "redirect:/";
//		}
	
	@GetMapping("idCheck")
	@ResponseBody
	public Long getIdCheck(String id)throws Exception{
		Long result = memberService.getIdCheck(id);
		return result;
	}

}
