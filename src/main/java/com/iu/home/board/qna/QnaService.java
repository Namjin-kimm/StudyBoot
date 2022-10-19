package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.getRowNum();
		List<QnaVO> ar = qnaMapper.getList(pager);
		return ar;
		
	}
	
	public int setInfo(QnaVO qnaVO)throws Exception{
		
		for(MultipartFile f: qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName :" + f.getOriginalFilename());
			}
		}
		
		return 1;//qnaMapper.setInfo(qnaVO);
	}

}
