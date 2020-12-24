<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${item.itemname}</title>
<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css"> 
</head>
<body>
	<div align="center" class="body">
		<h2>${item.itemname}</h2>
		<table border="1">
			<tr>
				<td><img src="${pageContext.request.contextPath}/img/${item.pictureurl}" 
				width="200" height="200"></td>
				<td align="center">
				<table>
					<tr height="50">
						<td width="80">상품이름</td>
						<td width="160">${item.itemname}
						</td>
					</tr>
					<tr height="50">
						<td width="80">가격</td>
						<td width="160">${item.price}
						</td>
					</tr>
					<tr height="50">
						<td width="80">설명</td>
						<td width="160">${item.description}
						</td>
					</tr>
					<tr height="50">
						<td colspan="2" aligh="center"
						width="240">
						<a href="${pageContext.request.contextPath}/">목록으로</a>
						</td>
					</tr>	
				</table>
			</tr>	
		</table>
	
	</div>
</body>
</html>