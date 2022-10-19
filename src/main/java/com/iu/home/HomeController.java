package com.iu.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;

@Controller
public class HomeController {
	
	@Value("${my.message.hi}")
	private String message;
	
//	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@GetMapping("/")
	public String home()throws Exception {
		log.error("Error message");
		log.warn("Warning message");
		log.info("Info message");
		log.debug("Debug message");
		log.trace("Trace message");
		
//		List<QnaVO> ar = qnaMapper.getList();
		
//		log.info("List : {}  size {}", ar, ar.size());		
		return "index";
	}

}
