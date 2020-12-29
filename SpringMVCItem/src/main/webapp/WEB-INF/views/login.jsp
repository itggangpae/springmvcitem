<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 메시지 출력과 Spring의 form 태그 사용을 위한 설정 -->
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form:form modelAttribute="member">
		<p>
			<form:input path="email"
			placeholder="이메일을 입력하세요" />
			<form:errors path="email" />
		</p>
		<p>
			<form:password path="password"
			placeholder="비밀번호를 입력하세요" />
			<form:errors path="password" />
		</p>
		<p>
			<form:select path="logintype"
			items="${logintypes}" />
		<p>
			<input type="submit" value="로그인"/>
		</p>	
	</form:form>
</body>
</html>