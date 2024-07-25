<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 목록 조회</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>공지사항 목록 조회</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${nList }" var="notice">
				<tr>
					<td>${notice.noticeNo }</td>
					<td>${notice.noticeSubject }</td>
					<td>${notice.noticeWriter }</td>
					<td>${notice.noticeDate }</td>
					<td>${notice.viewCount }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>