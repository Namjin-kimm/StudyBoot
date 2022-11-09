<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<div class="container">
		<h1>Login Page</h1>
		
		<div>
			<h3>${param.error}</h3>
			<h3>${param.message}</h3>
			<h3>${requestScope.msg}</h3>
		</div>
	
		<form action="login" method="post">
			<div class="container col-lg-6">
				<div class="mb-3">
					<label for="id" class="form-label">ID</label>
					<input type="text" class="form-control" id="id" value="${cookie.userId.value}" aria-describedby="emailHelp" placeholder="ID" name="id">
				</div>
				<div class="mb-3">
					<label for="pw" class="form-label">PW</label>
					<input type="text" class="form-control" id="pw" value="admin1" aria-describedby="emailHelp" placeholder="PW" name="pw">
				</div>
				<div class="mb-3">
					<input type="checkbox" name="rememberId" class="form-check-input" id="checkbox=">ID 기억하기
				</div>
				<div>
					<input type="checkbox" name="rememberMe" class="form-check-input" id="exampleCheck2">Remember Me
				</div>
				<sec:csrfInput/>
				<button type="submit" class="btn btn-primary">LOGIN</button>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		//history.replaceState({}, null, location.pathname)
	</script>
</body>
</html>