package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;

	
	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.getRowNum();
		List<QnaVO> ar = qnaMapper.getList(pager);
		return ar;
		
	}
	
//	@Transactional(rollbackFor = Exception.class)
	public int setInfo(QnaVO qnaVO)throws Exception{
		
		int result = qnaMapper.setInfo(qnaVO);
//		realpath는 이제 쓸 필요 X
//		String realpath = session.getServletContext().getRealPath("/static/upload/qna"); 
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
			log.info("Check : " + check);
		}
		
		for(MultipartFile f: qnaVO.getFiles()) {
			// f가 비어있다면 예외를 강제로 발생시키겠다는 것
			if(f.isEmpty()) {
				log.info("-------- Exception 발생 --------");
				throw new Exception();
			}
			
			if(!f.isEmpty()) {
				log.info("FileName :" + f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setAddFile(qnaFileVO);
			}
			
		}
		return result;
	}
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception{
		return qnaMapper.getDetail(qnaVO);
	}

}
