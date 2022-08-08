<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#writeForm{
	width:500px;
	border: 1px solid red;
	margin: auto;
}

h2{
	text-align: center;
}

table{
	margin:auto;
	width:450px;
}

.td_left{
	width:150px;
	background: orange;
}

.td_right{
	width: 300px;
	background: skyblue;
}

#commandCell{
	text-align: center;
}
</style>
 <script>
	function setThumbnail(event) {
		var reader = new FileReader();
	
		reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		document.querySelector("div#image_container").appendChild(img);
		};
	
		reader.readAsDataURL(event.target.files[0]);
	}
</script>
</head>
<body>
	<section id="writeForm">
		<h2>식당 글 등록</h2>
		<form action="BoardWritePro.bo" method="post" enctype="multipart/form-data" name="boardform">
			<table>
				<tr>
					<th><label for="res_name">식당이름</label></th>
					<td><input type="text" name="res_name" id="res_name" required="required"></td>
				</tr>
				<tr>
					<th><label for="r_postcode">우편번호</label></th>
					<td><input type="text" name="r_postcode" id="r_postcode" required="required"></td>
				</tr>
				<tr>
					<th><label for="address">상세주소</label></th>
					<td><input type="text" name="address" id="address" required="required"></td>
				</tr>
				<tr>
					<th><label for="phone_number">식당 전화번호</label></th>
					<td><textarea id="phone_number" name="phone_number" cols="40" rows="15" required="required"></textarea></td>
				</tr>
				
				<tr>
					<th><label for="res_info">식당 상세 정보</label></th>
					<td><textarea id="res_info" name="res_info" cols="40" rows="15" required="required"></textarea></td>
				</tr>
				<tr>
					<th><label for="photo">식당 사진</label></th>
					<td><input name="photo" type="file" id="photo"  accept="image/*" onchange="setThumbnail(event);"></td>
				</tr>
					
				<tr>
					<th><label for="res_link">식당 웹사이트 링크</label></th>
					<td><textarea id="res_link" name="res_link" cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<h3>이미지 미리보기</h3>
			<div id="image_container"></div>
			<h3 style="text-align: center"> 영업 시간 등록</h3>
					<b>월</b> <input type="time">~<input type="time"> 또는 휴무<input type="checkbox" name="Monday" value="휴무"><br>
					<b>화</b> <input type="time">~<input type="time"> 또는 휴무<input type="checkbox" name="Tuesday" value="휴무"><br>
					<b>수</b> <input type="time">~<input type="time"> 또는 휴무<input type="checkbox" name="Wednesday" value="휴무"><br>
					<b>목</b> <input type="time">~<input type="time"> 또는 휴무<input type="checkbox" name="Thursday" value="휴무"><br>
					<b>금</b> <input type="time">~<input type="time"> 또는 휴무<input type="checkbox" name="Friday" value="휴무"><br>
					<br>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기">
				<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	
</body>
</html>