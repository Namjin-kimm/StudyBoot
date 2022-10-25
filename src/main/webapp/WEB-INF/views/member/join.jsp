<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<form action="join" method="post">
		<div class="container col-lg-6">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<input type="text" class="form-control" id="id" aria-describedby="emailHelp" placeholder="ID" name="id">
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<input type="text" class="form-control" id="pw" aria-describedby="emailHelp" placeholder="PW" name="pw">
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="NAME" name="name">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<input type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="EMAIL" name="email">
			</div>
			<button type="submit" class="btn btn-primary">JOIN</button>
		</div>
	</form>

</body>
</html>