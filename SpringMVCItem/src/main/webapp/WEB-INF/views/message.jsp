<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 스프링 메시지 출력을 위한 태그 라이브러리 설정 -->
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.form.title" /></title>
</head>
<body>
<form action="loginform" method="post">
	<p>
		<label for="email">
		<spring:message code="email"/>
		</label>
		<input type="text" id="email" name="email"/>
	</p>
	<p>
		<label for="password">
		<spring:message code="password"/>
		</label>
		<input type="password" 
		id="password" name="password"/>
	</p>
	<input type="submit" value=
	"<spring:message code="login.form.login"/>">
	<ul>
		<li><spring:message code="login.form.help"/></li>
	</ul>
</form>
</body>
</html>