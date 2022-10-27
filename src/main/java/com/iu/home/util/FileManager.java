package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView{
	@Value("${app.download.base}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QnaFileVO qnaFileVO = (QnaFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		log.info("==============================");
		log.info("FILEVO{}", qnaFileVO);
		
		//받아올 파일
		File file = new File(base+path, qnaFileVO.getFileName());
		log.info(qnaFileVO.getFileName());
		
		//한글 처리
		response.setCharacterEncoding("UTF-8");
		
		//총 파일의 크기
		response.setContentLengthLong(file.length());
		
		//다운로드시 파일의 이름을 인코딩
		String oriName = URLEncoder.encode(qnaFileVO.getOriName(), "UTF-8");
		
		//header 설정(부가정보를 알려주는 것)
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일을 읽고 
		FileInputStream fi = new FileInputStream(file);
		//Client로 전송 준비
		OutputStream os = response.getOutputStream();
		
		//전송(multipartFile이 없으므로 FileCopyUtils 사용)
		FileCopyUtils.copy(fi, os);
		
		//자원 해제(역순으로)
		os.close();
		fi.close();
		
	}
	
	
	public String saveFile(MultipartFile multipartFile, String path)throws Exception{
		//1. 중복되지 않는 파일명을 생성(UUID, Date)
		String fileName = UUID.randomUUID().toString();
		
		//2. 확장자, 확장자를 붙여주기 위해 original fileName을 앞서 구한 fileName에 붙여준다.
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		//bf.append(multipartFile.getOriginalFilename());
		log.info("filName {}",bf.toString());
		
		//파일명과 확장자 분리
		String ex = multipartFile.getOriginalFilename(); //아이유.jpg
		ex = ex.substring(ex.lastIndexOf("."));
		bf.append(ex);
		fileName = bf.toString();
		
		//3. File 저장하기
		File file = new File(path, fileName);
		
		//FileCopyUtils
		//MultipartFile
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	//HDD에서 파일 삭제
	public boolean deleteFile(String path, QnaFileVO qnaFileVO)throws Exception{
		File file = new File(path, qnaFileVO.getFileName());
		return file.delete();
	}

}
