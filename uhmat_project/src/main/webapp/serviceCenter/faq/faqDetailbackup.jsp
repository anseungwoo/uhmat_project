<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 글 보기</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 550px;
		border: 1px solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 500px;
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: 70px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>글 상세내용 보기</h2>
		<section id="basicInfoArea">
				<table border="1">
					<tr><th width="70">제 목</th><td colspan="3" >${faq.subject }</td></tr>
					<tr>
						<th width="70">작성자</th><td>${faq.nickname }</td>
						<th width="70">작성일</th><td>${faq.date }</td>
						<th>조회수</th><th>${faq.readcount }</th>
<%-- 						<th>카테고리</th><td>${faq.category }</td> --%>
					</tr>
					<tr>
						<th width="70">첨부파일</th>
						<td>
						<!-- 
						파일명은 원본 파일명을 표시하고, 다운로드 파일 대상은 실제 업로드 파일명,
						실제 다운로드 되는 파일명은 원본 파일명으로 변경하여 다운로드
						-->
							<a href="upload/${faq.real_File }" download="${faq.original_File }">
							${faq.real_File }
							</a>
						</td>
					</tr>
				</table>
		</section>
		<section id="articleContentArea">
			${faq.content }
		</section>
	</section>
	<section id="commandList">
		<input type="button" value="수정" onclick="location.href='FAQModifyForm.sc?idx=${faq.idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='FAQDelete.sc?idx=${faq.idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='FAQList.sc?pageNum=${param.pageNum}'">
	</section>
</body>
</html>
















