package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;
	
////	@BeforeAll
//	static void befoAll() {
//		System.out.println("전체 Test 실행 전!!!");
//	}
//	
////	@AfterAll
//	static void afterAll() {
//		System.out.println("전체 Test 실행 후!!!");
//	}
//	
////	@BeforeEach
//	void beforeEach() {
//		System.out.println("Test 메서드 실행 전");
//		QnaVO qnaVO = new QnaVO();
//	}
//	
////	@AfterEach
//	void afterEach() {
//		System.out.println("Test 메서드 실행 후");
//	}
//	
////	@Test
//	void test2() {
//		log.info("Test2 Case");
//	}
//
////	@Test
//	void selectTest()throws Exception {
//		List<QnaVO> ar = qnaMapper.getList();
//		log.info("List {}", ar);
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
//	void insertTest()throws Exception{
//		for(int i = 0; i <=100; i++) {
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setWriter("tt");
//		qnaVO.setTitle("tt");
//		qnaVO.setContents("tt");
//		qnaVO.setHit(0L);
//		qnaVO.setRef(0L);
//		qnaVO.setStep(0L);
//		qnaVO.setDepth(0L);
//		int result = qnaMapper.setInfo(qnaVO);
//		assertNotEquals(0, result);
//		}
//	}

}
