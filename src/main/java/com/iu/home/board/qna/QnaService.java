package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.getRowNum();
		List<QnaVO> ar = qnaMapper.getList(pager);
		return ar;
		
	}
	
	public int setInfo(QnaVO qnaVO)throws Exception{
		return qnaMapper.setInfo(qnaVO);
	}

}
