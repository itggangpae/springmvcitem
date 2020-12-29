<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 추가</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		상품명:<input type="text" id="itemname"
		name="itemname" /><br/>
		가격:<input type="text" id="price"
		name="price" /><br/>
		설명:<input type="text" id="description"
		name="description" /><br/>
		이미지:<input type="file" id="pictureurl"
		name="pictureurl" accept="image/*"/><br/>
		<input type="submit" value="추가" />
	
	</form>
</body>
</html>