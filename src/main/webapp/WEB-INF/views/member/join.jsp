<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/util.js"></script>
<script defer src="/js/memberAdd.js"></script>
</head>
<body>
	<form action="join" method="post" id="joinForm">
		<div class="container col-lg-6">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<input type="text" class="form-control" id="id" aria-describedby="emailHelp" placeholder="ID" name="id">
				<div id="idm" style="color: red;"></div>
				<div id="idm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<input type="text" class="form-control" id="pw" aria-describedby="emailHelp" placeholder="PW" name="pw">
				<div id="pwm" style="color: red;"></div>
				<div id="pwm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="pwCheck" class="form-label">PW 확인</label>
				<input type="text" class="form-control" id="pwCheck" aria-describedby="emailHelp" placeholder="PW Check">
				<div id="pwCheckm" style="color: red;"></div>
				<div id="pwCheckm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="NAME" name="name">
				<div id="namem" style="color: red;"></div>
				<div id="namem2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<input type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="EMAIL" name="email">
				<div id="emailm" style="color: red;"></div>
				<div id="emailm2" style="color: blue;"></div>
			</div>
			<button type="button" id="joinButton" class="btn btn-primary">JOIN</button>
		</div>
	</form>
	
	<!-- 약관 test -->
	<div class="row justify-content-center mt-5">
		<div>
			ALL <input type="checkbox" id="all">
		</div>	

		<div>
			동의1 <input type="checkbox" class="check" name="" id="">
			<div>
				약관1
			</div>
		</div>

		<div>
			동의2 <input type="checkbox" class="check" name="" id="">
			<div>
				약관2
			</div>
		</div>

		<div>
			동의3 <input type="checkbox" class="check" name="" id="">
			<div>
				약관3
			</div>
		</div>
	</div>

</body>
</html>