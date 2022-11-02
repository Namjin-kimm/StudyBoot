package com.iu.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.home.board.qna.QnaMapper;

@Controller
public class HomeController {
	
//	@Value("${my.message.hi}")
	private String message;
	
//	@Value("${my.default}")
	private String app;
	
//	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/user")
	@ResponseBody
	public String member() {
		return "Member Role";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "Manager Role";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Role";
	}
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@GetMapping("/")
	public String home()throws Exception {
//		log.error("Error message");
//		log.warn("Warning message");
//		log.info("Info message");
//		log.debug("Debug message");
//		log.trace("Trace message");
		
		log.info("====================");
		log.info("message {}", message);
		log.info("default {}", app);
		log.info("====================");
		
//		List<QnaVO> ar = qnaMapper.getList();
		
//		log.info("List : {}  size {}", ar, ar.size());		
		return "index";
	}

}
