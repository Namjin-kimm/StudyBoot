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
<script defer src="/js/fileManager.js"></script>
</head>
<body>
	<form action="update" method="post" id="updateForm">
		<div class="container col-lg-6">
            <h1>Update Page</h1>
            <input type="hidden" value="${vo.num}">
			<div class="mb-3">
				<label for="writer" class="form-label">WRITER</label>
				<input type="text" class="form-control" id="writer" aria-describedby="emailHelp" value="${vo.writer}" name="writer" readonly="readonly">
			</div>
			<div class="mb-3">
				<label for="title" class="form-label">TITLE</label>
				<input type="text" class="form-control" id="title" aria-describedby="emailHelp" value="${vo.title}" name="title">
			</div>
                <div class="mb-3">
                    <label for="contents" class="form-label">Contents</label>
                    <textarea class="form-control" id="contents" aria-describedby="emailHelp" name="contents">${vo.contents}</textarea>
                </div>
			</div>

            <div class="mb-3" id="fileList" data-file-size="${vo.qnaFileVOs.size()}"></div>
            <c:forEach items="${vo.qnaFileVOs}" var="fileVO">
                <p>${fileVO.oriName}
                    <button class="btn btn-danger deleteFile" data-fileNum="${fileVO.fileNum}" type="button">삭제</button>
                </p>
            </c:forEach>
            <div class="mb-3" id="fileAdd">

			</div>
			<div class="mb-3">
				<button type="button" id="fileAddButton">FileAdd</button>
			</div>
			<button type="button" id="joinButton" class="btn btn-primary">수정하기</button>
		</div>
	</form>

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