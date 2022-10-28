<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script defer src="/js/fileManager.js"></script>
</head>
<body>
	
	<div class="container col-lg-6">
		<h1>Board Write Page</h1>
		<%-- <form action="./write" method="post" enctype="multipart/form-data"> --%>
		<form:form method="post" modelAttribute="qnaVO" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<form:input path="writer" cssClass="form-control" id="writer"/>
				<!-- <input type="text" class="form-control" id="writer" aria-describedby="emailHelp" placeholder="Writer" name="writer"> -->
				<form:errors path="writer"></form:errors>
			</div>
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<form:input path="title" cssClass="form-control" id="title"/>
				<!-- <input type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Title" name="title"> -->
				<form:errors path="title"></form:errors>
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<form:textarea path="contents" cssClass="form-control" id="contents"/>
				<!-- <textarea class="form-control" id="contents" aria-describedby="emailHelp" name="contents"></textarea> -->
				<form:errors path="contents"></form:errors>
			</div>

			<div class="mb-3" id="fileAdd">

			</div>
			<div class="mb-3">
				<button type="button" id="fileAddButton">FileAdd</button>
			</div>

			<!-- <div class="mb-3">
				<label for="files" class="form-label">Files</label>
				<input type="file" name="files">
			</div>
			<div class="mb-3">
				<label for="files" class="form-label">Files</label>
				<input type="file" name="files">
			</div> -->
				<input type="hidden" name="hit" value="0">
				<input type="hidden" name="ref" value="0">
				<input type="hidden" name="depth" value="0">
				<input type="hidden" name="step" value="0">

				<button class="btn btn-primary" type="submit">등록하기</button>
		<%-- </form> --%>
		</form:form>
	</div>


	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	<script type="java/template" id="fileAddForm">
		<div class="mb-3">
		<label for="files" class="form-label">Files</label>
		<input type="file" name="files">
		<button type="button" class="del">X</button>
		</div>
	</script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
</body>
</html>