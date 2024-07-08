<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>책 하나</title>
	</head>
	<body>
		<p>책 제목 : ${book.bookName }</p>
		<p>저자 : ${book.bookWriter }</p>
		<p>가격 : ${book.bookPrice }</p>
		<p>출판사 : ${book.publisher }</p>
		<p>장르 : ${book.genre }</p>
		<a href="/book/list.do">리스트로 돌아가기</a>
	</body>
</html>