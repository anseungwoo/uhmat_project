<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome reviewList</h1>

	<nav><a href="ReviewWriteForm.re">글 작성</a></nav>
	<hr>
	<section>
		<table border="2">
				<c:choose>
					<c:when test="${not empty reviewList and pageInfo.listCount gt 0}">
						<c:forEach var="board" items="${reviewList}">
							<tr onclick="location.href='ReviewDetail.re?idx=' + ${board.idx}+'&pageNum=' +${pageInfo.pageNum}">
								<td>${board.photo }</td>
								<td>${board.idx }</td>
								<td>${board.nickname }</td>
								<td>${board.subject }</td>
								<td>tag</td>
								<td>${board.rating}</td>
								<td>${board.likes}</td>
								<td width="70%">${board.content}</td> <!-- 이부분에서 나중에 댓글 항목 추가, 더보기 란 할 수 있도록 해야함 -->
							</tr>
						</c:forEach>
					</c:when>
				<c:otherwise>
					<tr>
						<td colspan="8">게시글이 존재하지 않습니다.</td>
					</tr>
				</c:otherwise>
				</c:choose>
		</table>
	</section>
	<section id="pageList">
			<!-- 
			현재 페이지 번호(pageNum)가 1보다 클 경우에만 [이전] 링크 동작
			=> 클릭 시 BoardList.bo 서블릿 주소 요청하면서 
		   현재 페이지 번호(pageNum) - 1 값을 page 파라미터로 전달
			-->
			<c:choose>
				<c:when test="${pageInfo.pageNum > 1}">
					<input type="button" value="이전" onclick="location.href='ReviewList.re?pageNum=${pageInfo.pageNum - 1}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="이전">
				</c:otherwise>
			</c:choose>
			
			<!-- 페이지 번호 목록은 시작 페이지(startPage)부터 끝 페이지(endPage) 까지 표시 -->
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
				<!-- 단, 현재 페이지 번호는 링크 없이 표시 -->
				<c:choose>
					<c:when test="${pageInfo.pageNum eq i}">
						${i }
					</c:when>
					<c:otherwise>
						<a href="ReviewList.re?pageNum=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	
			<!-- 현재 페이지 번호(pageNum)가 총 페이지 수보다 작을 때만 [다음] 링크 동작 -->
			<c:choose>
				<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
					<input type="button" value="다음" onclick="location.href='ReviewList.re?pageNum=${pageInfo.pageNum + 1}'">
				</c:when>
				<c:otherwise>
					<input type="button" value="다음">
				</c:otherwise>
			</c:choose>
		</section>

</body>
</html>