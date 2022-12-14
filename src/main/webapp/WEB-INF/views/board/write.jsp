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

				<button class="btn btn-primary" type="submit">????????????</button>
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
		$("#contents").summernote({
			tabsize: 4,
			height: 250,
			callbacks: { //summernote??? ????????? ?????? ?????? ??????
				onImageUpload: function(file){ //???????????? ????????? ??????
					console.log("ImageUpload");
					console.log("File : ", file);
					uploadFile(file);
				},
				onMediaDelete: function(file){
					console.log("Delete Media");
					deleteFile(file);
				}
				
			}
		});
		//ajax Upload ??????
		function uploadFile(file){
			console.log("file : ", file);
			
			//form
			const formData = new FormData();
			//input type = file
			formData.append('files', file[0]);
			
			$.ajax({
				type: "POST",
				url: "summerFile",
				data: formData, //files ??? ??????????????? ?????????
				//header
				cache: false,
				processData: false,
				contentType: false,
				enctype: "multipart/form-data",
				success: function(img){//HDD??? ?????? ??? file??? ????????? ????????? ???????????? ??????
					//img = image ?????? ??????
					console.log("Image => ", img);
					//const imgTag = 'img src=' + img + '>'; //????????? ????????? ??????
					//$("#contents").summernote('pasteHTML', imgTag); //summernote ????????? HTML ?????? ??????
					//===============
					//$("#contents").summernote('insertImage', img, 'test.jpg'); //?????? ??????
					$("#contents").summernote('insertImage', img, file[0].name);
					//?????? ????????? ???????????? contents ????????? ????????? ?????????
				},
				error: function(){
					console.log('Image Upload Error');
				}
			})
		}

		function deleteFile(file){
			console.log("image src: ", file.attr("src"))  //file??? ?????? ????????????????????????. file??? ????????? ???????????????, ?????????
			//file??? ???????????? ????????? element??? ?????????.
			//fileName????????? ????????? ??????????????? ?????? ?????? ??????
			$.post("./summerFileDelete", {fileName: file.attr("src")}, function(result){
				console.log(result)
			})
		}
	</script>
</body>
</html>