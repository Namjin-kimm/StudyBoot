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
	
	public boolean summerFileDelete(String fileName)throws Exception{
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
		QnaFileVO qnaFileVO = new QnaFileVO();
		qnaFileVO.setFileName(fileName);
		return fileManager.deleteFile(path, qnaFileVO);
	}
	
	public String setSummerFile(MultipartFile files)throws Exception{
		String fileName = fileManager.saveFile(files, path);
		//우리가 파일을 HDD에 저장할때 요청되는 경로와, 파일을 불러올때 요청하는 url이 다르기 때문에
		fileName = "/file/qna/" + fileName;
		return fileName;
	}

	
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
//			if(f.isEmpty()) {
//				log.info("-------- Exception 발생 --------");
//				throw new Exception();
//			}
			
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
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO)throws Exception{
		return qnaMapper.getFileDetail(qnaFileVO);
	}
	
	public int setFileDelete(QnaFileVO qnaFileVO)throws Exception{
		log.info("setFileDelete");
		// fileName, oriName 불러오기
		qnaFileVO = qnaMapper.getFileDetail(qnaFileVO);
		String fileName = qnaFileVO.getFileName();
		log.info("FileName : {}", fileName);
		//DB에서 사진 삭제
		int result = qnaMapper.setFileDelete(qnaFileVO);
		log.info("Result : {}", result);
		//HDD에서 사진 삭제
		if(result > 0) {
			fileManager.deleteFile(path, qnaFileVO);
		}
		return result;
	}

}
