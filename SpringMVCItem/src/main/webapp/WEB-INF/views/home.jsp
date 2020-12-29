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
		
		<a href="item.xls">엑셀 다운로드</a><br/>
		<a href="item.pdf">pdf 다운로드</a><br/>
		<a href="view.json">view를 이용한 json 출력</a><br/>
		<a href="controller.json">RestController를 이용한 json 출력</a><br/>
		<a href="#" id="display">ajax로 데이터 가져오기</a><br/>
		<a href="item.xml">XML 요청</a><br/>
		<a href="message">스프링 메시지 출력</a><br/>
		<a href="login">로그인</a><br/>
		<a href="iteminsert">아이템 추가</a><br/>
		
		<form action="cal" method="post"id="cal">
			첫번째 수:<input type="text" 
			id="num1" name="num1" /><br/>
			두번째 수:<input type="text" 
			id="num2" name="num2" /><br/>
			<input type="submit" value="더하기" />
		</form>
	</div>
	
	<div align="center" class="body" id="disp">
	</div>
	
	<script>
		document.getElementById("display")
			.addEventListener("click", function(e){
			//ajax 객체 생성
			var request = new XMLHttpRequest();
			//ajax 요청
			request.open('get', 'controller.json');
			request.send('');
			request.addEventListener('load', function(data){
				//데이터 확인
				//alert(request.responseText);
				//alert(data.target.responseText);
				
				//파싱
				var obj = JSON.parse(request.responseText);
				
				//파싱 결과를 확인
				//alert(obj.count);
				//alert(obj.list);
				
				//출력 영역 찾아오기 
				var disp = document.getElementById("disp");
				//출력할 내용 만들기
				var content = "";
				
				content += "<h2>상품 목록 화면</h2>";
				content += "<table border='1'>";
				
				content += "<tr class='header'>";
				content += "<th align='center' width='80'>상품 코드</th>";
				content += "<th align='center' width='320'>상품명</th>";
				content += "<th align='center' width='100'>가격</th>";
				content += "<th align='center' width='100'>이미지</th>";
				content += "</tr>";
				for(i in obj.list){
					//list의 각 데이터 가져오기
					var item = obj.list[i];
					content += "<tr class='record'>";
					content += "<td align='center'>" + item.itemid + "</td>";
					content += "<td>" + item.itemname + "</td>";
					content += "<td align='right'>" + item.price + "원</td>";
					content += "<td><a href='download?filename=";
					content += item.pictureurl + "'>"
					content += item.pictureurl + "</a></td>";			
					content += "</tr>";
				}
				
				content += "</table>";
				disp.innerHTML = content;
			});
		});
	
	</script>
</body>
</html>