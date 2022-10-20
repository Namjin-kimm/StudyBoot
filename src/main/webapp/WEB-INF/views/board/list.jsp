<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<div class="container">
	<h1>List Page</h1>
		<table class="table table-hover" id="table" style="cursor: pointer;">
	        <thead>
	            <tr>
	                <th>번호</th><th>질문자</th><th>제목</th><th>내용</th><th>조회수</th><th>등록날짜</th>
	                <th>REF</th><th>STEP</th><th>DEPTH</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${list}" var="dto">
	                    <tr class="parent" data-num="${dto.num}">
	                        <td><a href="./detail?num=${dto.num}">${dto.num}</a></td>
	                        <td>${dto.writer}</td>
	                        <td>${dto.title}</td>
	                        <td>${dto.contents}</td>
	                        <td>${dto.hit}</td>
	                        <td>${dto.regDate}</td>
	                        <td>${dto.ref}</td>
	                        <td>${dto.step}</td>
	                        <td>${dto.depth}</td>
	                    </tr>
	            </c:forEach>
	        </tbody>
	    </table>
		<div>
			<a class="btn btn-success" href="./write">WRITE</a>
		</div>
	</div>
	
	<script type="text/javascript">
		let result = '${param.result}';
		if(result !=""){
			if(result == '1'){
				alert("등록 성공");
			}else{
				alert("등록 실패");
			}
		}
	</script>
	

</body>
</html>