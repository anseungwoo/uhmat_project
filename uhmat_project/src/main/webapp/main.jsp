<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}css/reviewList.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.6.0.js"></script>
<!-- <link href="css/header.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="css/footer.css" rel="stylesheet" type="text/css"> -->
<script type="text/javascript">
	
	//content 글자 수 제한 코드 
	$(document).ready(function(){
	    $('p[id^=content]').each(function(){
	        if ($(this).text().length > 120) {
	        $(this).html($(this).text().substr(0,120)+"<br>" +"<span id='highlight' onclick='more()'>...더보기</span>");
	        }
	    });
	    
	  window.onload = function(){
	   	   $.ajax({
	   		 
	   			type: "post",
	   			url: "ReviewBest.ma",	//리뷰를 좋아요 순으로 가져오는 요청
	   		
	   			dataType: "text",
	   			async : false,
	   			success: function(response) {
	   					var content = $("#bestReviewList").html(response).find("#listView>img").eq(0);
	   					$("#bestReviewList").html(content.attr('src'));
	   					alert(content.attr('src'));
	   		   },
	   	});
	  }
	
	});
	
</script>
<style>
	.star-rating {width:205px; }
	.star-rating,.star-rating span {display:inline-block; height:39px; overflow:hidden; background:url(image/star3.png)no-repeat; }
	.star-rating span{background-position:left bottom; line-height:0; vertical-align:top; }
</style>
</head>
<body>
	<!-- 헤더 들어가는곳 -->
		<jsp:include page="inc/header.jsp" flush="false" />
	<!-- 헤더 들어가는곳 -->
	
	<!-- 사이드바 들어가는곳 -->
<%-- 		<jsp:include page="inc/sidebar.jsp" flush="false" /> --%>
	<!-- 사이드바 들어가는곳 -->
<!-- 	<hr>		 -->
			
	<!-- 메인페이지 영역 시작 -->
	<div class="mainContainer">	
	<!-- 검색창 시작 -->
	<div class="mainImageContainer">
		<img class="mainImage" src="image/mainSample3.jpg">
	</div>
	<!-- 검색창 끝 -->
	
	<!-- 본문들어가는 곳 시작 -->
	

	
		<!-- 최고의 리뷰 순위 시작 -->
		<div class="mainViewContainer">	
			<div class="rankContainer">
				<div class = "imgContainer" ><h2>최다 좋아요 리뷰</h2>
						<section id="mother">
							<section>
								<a href="ReviewBest.ma">아무거나</a>
									<div id="bestReviewList">
										<tr>
											<td><img src="image/sample1.jpg" width="400" height="300"></td>
											<td><img src="image/sample2.jpg" width="400" height="300"></td>
											<td><img src="image/sample3.jpg" width="400" height="300"></td>
										</tr>
									</div>
							</section>
						</section>
						<section id="append" style="display:none;">
						
						</section>
				</div>
			</div>
		<!-- 최고의 리뷰 순위 끝 -->
		
		<!-- 최신 리뷰 시작 -->
			<div class="rankReview">
				<div class = "imgContainer"><h2>어맛 최신 리뷰</h2>
					<div id="bestResList">
		
					</div>
				</div>
			</div>
		<!-- 최신 리뷰 끝 -->
		
		<!-- 어맛 추천 리뷰 시작 -->
			<div class="rankReview">
				<div class = "imgContainer"><h2>어맛 추천 리뷰</h2>
					
				</div>
			</div>
		<!-- 어맛 추천 리뷰 끝 -->
		
		<!-- 리뷰어 창 시작 -->
			<div class="reviewer">
				<div class = "imgContainer"><h2>어맛 리뷰어</h2>
					<div class = "mainView" >
						<ul>
							<li><img src="image/sample1.jpg" width="100%" /></li>
							<li><img src="image/sample2.jpg" width="100%" /></li>
							<li><img src="image/sample3.jpg" width="100%" /></li>
							<li><img src="image/sample4.jpg" width="100%" /></li>
							<li><img src="image/sample5.jpg" width="100%" /></li>
						</ul>
					</div>
				</div>
			</div>
		</div>	
		<!-- 리뷰어 창 끝 -->
		
		
		
	</div>
<!-- 메인페이지 영역 끝 -->		
<!-- <hr> -->
		
	<!-- 푸터 들어가는곳 시작 -->
		<jsp:include page="inc/footer.jsp" flush="false" />
	<!-- 푸터 들어가는곳 끝 -->		

</body>
</html>   