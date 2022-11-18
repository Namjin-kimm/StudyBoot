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
		$("#contents").summernote({
			tabsize: 4,
			height: 250,
			callbacks: { //summernote의 이벤트 콜백 함수 등록
				onImageUpload: function(file){ //이미지가 업로드 되면
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
		//ajax Upload 함수
		function uploadFile(file){
			console.log("file : ", file);
			
			//form
			const formData = new FormData();
			//input type = file
			formData.append('files', file[0]);
			
			$.ajax({
				type: "POST",
				url: "summerFile",
				data: formData, //files 가 파라미터로 넘어감
				//header
				cache: false,
				processData: false,
				contentType: false,
				enctype: "multipart/form-data",
				success: function(img){//HDD에 저장 후 file을 불러올 경로와 파일명을 받음
					//img = image 소스 경로
					console.log("Image => ", img);
					//const imgTag = 'img src=' + img + '>'; //이미지 태그를 생성
					//$("#contents").summernote('pasteHTML', imgTag); //summernote 내부에 HTML 코드 넣기
					//===============
					//$("#contents").summernote('insertImage', img, 'test.jpg'); //태그 생성
					$("#contents").summernote('insertImage', img, file[0].name);
					//파일 저장이 완료되면 contents 부분에 사진이 올라감
				},
				error: function(){
					console.log('Image Upload Error');
				}
			})
		}

		function deleteFile(file){
			console.log("image src: ", file.attr("src"))  //file은 그냥 매개변수명일뿐임. file은 삭제된 대상이므로, 여기서
			//file을 사용하면 삭제된 element가 선택됨.
			//fileName이라는 변수에 파일경로를 담아 요청 발생
			$.post("./summerFileDelete", {fileName: file.attr("src")}, function(result){
				console.log(result)
			})
		}
	</script>
</body>
</html>