<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MateDeletePro.co?idx=${param.idx }&pageNum=${param.pageNum}" name="deleteForm" method="post">
	<h1>글 삭제 하시겠습니까?</h1>
<!-- 	<input type="password" placeholder="패스워드를 적으시오"> -->
<<<<<<< HEAD
	<input type="submit" value="삭제">&nbsp;&nbsp;
=======
	<input type="submit" value="삭제" >&nbsp;&nbsp;
>>>>>>> 12d6daae7722c81bcfb179bc331188d66ab1c611
	<input type="button" value="돌아가기" onclick="javascript:history.back()">
	</form>
	
</body>
</html>