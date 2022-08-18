<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="" method="get">
	<table border="1">
        <tr>
            <th>조건검색</th>
            <th>
	            <select>
	            	<option>등급선택</option>
	            </select>
            </th>
            <th>
	            <select>
	            	<option>고객명</option>
	            </select>
            </th>
            <th><input type="submit" value="검색"></th>
        </tr>
     </table>   
    </form>
        <!-- for문으로 여러개 출력하면 됩니다.(미구현) -->
    <table border="1">
        <tr>
            <td>가입일</td>
            <td><input type="date" name="startdate" >~<input type="date" name="enddate" > <br></td>
            <td>홍길동</td>
            
        </tr>
     </table>
     
	<table border="1">
        <tr>
            <th><input type="checkbox" id="allCheck"></th>
            <th>번호</th>
            <th>이름</th>
            <th>아이디</th>
            <th>닉네임</th>
            <th>휴대폰</th>
            <th>이메일</th>
            <th>방문수</th>
            <th>가입일</th>
            <th>상세보기</th>
        </tr>
        
        <!-- for문으로 여러개 출력하면 됩니다.(미구현) -->
        <tr>
            <td><input type="checkbox" id="check1" name="check" value="1"></td>
            <td>1</td>
            <td>홍길동</td>
            <td>hong</td>
            <td>hh</td>
            <td>010-1234-1234</td>
            <td>hong@naver.com</td>
            <td>2</td>
            <td>2022-08-18</td>
            <td>보기</td>
        </tr>
     </table>
	<br>
	<input type="button" value="회원삭제" onclick="location.href='회원삭제페이지'">
	<input type="button" value="이메일전송" onclick="location.href='이메일전송페이지'">
	<input type="button" value="SMS 발송" onclick="location.href='SMS 발송페이지'">
	
	<!-- 회원정보 나중에 ajax - append로 처리해야함 -->
	<div>
	<table border="1">
	<tr><td colspan="4" style="text-align: right">가입일 :  로그인 횟수:  마지막 로그인 :</td></tr>
	<tr><td>아이디</td><td><input type="text" name="id"></td><td>비밀번호</td><td><input type="text" name="passwd"></td></tr>
	<tr><td>이름</td><td><input type="text" name="name"></td><td>회원등급</td><td><select><option>일반회원</option><option>골드회원</option></select></td></tr>
	<tr><td>휴대폰</td><td colspan="3" ><input type="text" name="phonenumber1">-<input type="text" name="phonenumber2">-<input type="text" name="phonenumber3"></td></tr>
	<tr><td>이메일</td><td  colspan="3"><input type="text" name="email1">@<input type="text" name="email2"></td></tr>
	<tr><td>이메일 수신</td><td  colspan="3"><input type="radio" name="emailaccept">예 <input type="radio" name="emaildeny">아니오</td></tr>
	<tr><td>SMS 수신</td><td  colspan="3"><input type="radio" name="smsaccept">예 <input type="radio" name="smsdeny">아니오</td></tr>
	<tr><td rowspan="3">주소</td><td rowspan="3"><input type="text" placeholder="우편번호" name="address1"><input type="button" value="우편번호검색" onclick="우편번호 검색 링크"></td></tr>
	<tr><td  colspan="3"><input type="text" placeholder="상세주소1" name="address2"></td></tr>
	<tr><td  colspan="3"><input type="text" placeholder="상세주소2" name="address3"></td></tr>
	<tr><td>추천 닉네임</td><td colspan="3"><input type="text" name="recommendNickname"></td></tr>
	<tr><td>관리자메모</td><td><textarea rows="5" cols="20"></textarea></td></tr>
	
	</table>
	</div>
	


</body>
</html>  