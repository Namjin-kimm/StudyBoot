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
	<h1>Detail Page</h1>
		<table class="table table-striped" id="table" style="cursor: pointer;">
	        <thead>
	            <tr>
	                <th>num</th><th>writer</th><th>title</th><th>contents</th><th>hit</th><th>regDate</th>
	                <th>REF</th><th>STEP</th><th>DEPTH</th><th>PROFILE1</th><th>PROFILE2</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr>
	                <td>${vo.num}</td>
	                <td>${vo.writer}</td>
	                <td>${vo.title}</td>
	                <td>${vo.contents}</td>
	                <td>${vo.hit}</td>
	                <td>${vo.regDate}</td>
	                <td>${vo.ref}</td>
	                <td>${vo.step}</td>
	                <td>${vo.depth}</td>
					<c:forEach items="${vo.qnaFileVOs}" var="i">
						<td><p><img src="/file/qna/${i.fileName}" alt="" style="width: 100px; height: 100px;"></p></td>
						<td><a href="/fileDown/qna?fileNum=${i.fileNum}">${i.oriName}</a></td>
					</c:forEach>
	            </tr>
	            
	        </tbody>
	    </table>
	</div>

</body>
</html>