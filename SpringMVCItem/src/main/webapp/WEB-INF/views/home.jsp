<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 화면</title>
<!-- JSTL의 core 기능을 사용하기 위한 설정 -->
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
<!-- css 적용 : 상대 경로는 기준이 파일의 위치가 아니고 URL -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div align="center" class="body">
		<h2>상품 목록 화면</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">상품 코드</th>
				<th align="center" width="320">상품명</th>
				<th align="center" width="100">가격</th>
				<th align="center" width="100">이미지</th>
			</tr>
			
			<c:forEach var="item" items="${list}">
				<tr class="record">
					<td align="center">${item.itemid}</td>
					<td align="center">
					<a href="${pageContext.request.contextPath}/detail/${item.itemid}">
					${item.itemname}</a>
					</td>
					<td align="center">${item.price}</td>
					<td><a href="download?filename=${item.pictureurl}">
					${item.pictureurl}</a></td>
				</tr>
			</c:forEach>	
		</table>
		
		<a href="item.xls">엑셀 다운로드</a></br>
	</div>
	
</body>
</html>