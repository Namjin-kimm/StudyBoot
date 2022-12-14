package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.Pager;

//@Repository 생략 가능
@Mapper
public interface QnaMapper {
	
	public List<QnaVO> getList(Pager pager)throws Exception;
	
	public int setInfo(QnaVO qnaVO)throws Exception;
	
	public int setAddFile(QnaFileVO qnaFileVO)throws Exception;
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception;
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO)throws Exception;
	
	public int setFileDelete(QnaFileVO qnaFileVO)throws Exception;
	
}
