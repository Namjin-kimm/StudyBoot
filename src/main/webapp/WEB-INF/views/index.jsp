<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>IndexPage</h1>
	<h1><spring:message code="hi"></spring:message></h1>
	<h1><spring:message code="test" text="code가 없을 때 출력하는 메세지"></spring:message></h1>
	<c:if test="${not empty sessionScope.member}">
		<h3><spring:message code="welcome" arguments="${member.name}"></spring:message></h3>
		<h3><spring:message code="welcome2" arguments="${member.id}, ${member.name}" argumentSeparator=","></spring:message></h3>
	</c:if>
	<img src="./images/joyihyun.jpeg">
	<a href="./qna/list">QNA</a>
	<c:if test="${not empty sessionScope.member}">
		<a href="../member/join">Join</a>
		<a href="../member/logout">Logout</a>
	</c:if>
	<c:if test="${!not empty sessionScope.member}">
		<a href="../member/join">Join</a>
		<a href="../member/login">Login</a>
	</c:if>
	
	<div>
		<a href="/fileDown/qna?fileNum=4">click</a>
		<img alt="" src="/file/qna/joyihyun.jpg">
		<img alt="" src="/file/notice/joyihyun2.jpg">
		<a href="/fileDown/qna?fileNum=4">QnaDown</a>
		<a href="/fileDown/notice?fileNum=4">NoticeDown</a>
		<!-- 요청을 /file/** 로 보내지 않으면 WebConfig에서 가로채지 못하므로 Controller로 요청이 가게 됨 -->
	</div>
	
	<button id="btn">CLICK</button>

	<button class="buttons">BTN1</button>
	<button class="buttons">BTN2</button>
	<button class="buttons">BTN3</button>

	<div id="test">

	</div>
</body>
</html>