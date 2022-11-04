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
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@GetMapping("logout")
//	public String logout(HttpSession session)throws Exception{
//		log.info("==== 내가 만든 logout 메서드 ====");
//		session.invalidate();
//		return "redirect:/";
//	}
	
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
	
	@GetMapping("login") // Boolean 에 B를 대문자로 쓰는 이유는 null이 올 수 있기 때문에, Boolean은 참조타입
	public void login(@RequestParam(defaultValue = "false", required = false) boolean error, String message, Model model)throws Exception{
		if(error) {
			model.addAttribute("msg", "ID 또는 PW를 확인하세요");
		}
		//Controller에서 받아서 jsp로 보내도 됨
	}
	
	// 로그인
	@PostMapping("login")
	public String login()throws Exception{
	log.info("======== Login post ========");
		return "member/login";
		}
	
	@GetMapping("idCheck")
	@ResponseBody
	public Long getIdCheck(String id)throws Exception{
		Long result = memberService.getIdCheck(id);
		return result;
	}
	
	@GetMapping("mypage")
	public void getMyPage()throws Exception {
		
	}

}
