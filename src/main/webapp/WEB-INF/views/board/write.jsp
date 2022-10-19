<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
</head>
<body>
	
	<div class="container col-lg-6">
		<h1>Board Write Page</h1>
		<form action="" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<input type="text" class="form-control" id="writer" aria-describedby="emailHelp" placeholder="Writer" name="writer">
			</div>
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<input type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Title" name="title">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea class="form-control" id="contents" aria-describedby="emailHelp" name="contents"></textarea>
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Files</label>
				<input type="file" name="files">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Files</label>
				<input type="file" name="files">
			</div>
				<input type="hidden" name="hit" value="0">
				<input type="hidden" name="ref" value="0">
				<input type="hidden" name="depth" value="0">
				<input type="hidden" name="step" value="0">

				<button class="btn btn-primary" type="submit">등록하기</button>
		</form>
	</div>


	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
</body>
</html>