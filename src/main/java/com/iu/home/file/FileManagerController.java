package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;
import com.iu.home.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManagerController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/fileDown/{path}") //Restful, RestAPI
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO)throws Exception{
		log.info("Path {}", path);
		
		ModelAndView mv = new ModelAndView();
		//DB에서 정보 조회
		if(path.equals("qna")) {
//			qnaFileVO = qnaService.getFileDetail();
		}
		qnaFileVO.setFileName("joyihyun.jpg");
		qnaFileVO.setOriName("joyihyun.jpg");
		
		mv.addObject("fileVO",qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		//원래대로 라면 WEB-INF/views/fileManager.jsp 이렇게 찾아가야 하지만
		//BeanNameResolver 라는게 내장되어 있어서 이게 먼저 동작을 하게 된다
		//-> view의 이름과 일치하는 bean의 이름이 있으면 해당 Bean 실행
		//위에 Resolver가 없으면 InternalResourceViewResolver가 작동해서 jsp로 이동하게 된다.
		return mv;
	}
	
}
