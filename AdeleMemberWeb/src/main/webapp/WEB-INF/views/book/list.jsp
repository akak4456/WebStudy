<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>책 리스트</title>
	</head>
	<body>
		<ul>
			<c:forEach var="item" items="${books }">
				<li>코드 : ${item.bookNo } 제목 : ${item.bookName } 저자 : ${item.bookWriter } 가격 : ${item.bookPrice } 출판사 : ${item.publisher } 장르 : ${item.genre } <a href="/book/remove.do?bookNo=${item.bookNo }">책 삭제하기</a></li>
			</c:forEach>
		</ul>
		<a href="/book/add.do">책 추가하기</a>
		<form action="/book/onebycode.do" method="get">
			<fieldset>
				<legend>책 코드로 조회하기</legend>
				코드 : <input type="text" name="bookNo"><br>
				<input type="submit" value="조회하기">
			</fieldset>
		</form>
	</body>
</html>