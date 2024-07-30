<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 수정페이지</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>공지사항 상세 조회</h1>
		<form action="/notice/update.kh" method="post">
			<ul>
				<li>
					<label>번호</label>
					<span>${notice.noticeNo }</span>
					<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
				</li>
				<li>
					<label>작성일자</label>
					<span>${notice.noticeDate }</span>
				</li>
				<li>
					<label>제목</label>
					<input type="text" value="${notice.noticeSubject }" name="noticeSubject">
				</li>
				<li>
					<label>내용</label>
					<textarea rows="5" cols="40" name="noticeContent">${notice.noticeContent }</textarea>
				</li>
			</ul>
			<button>수정하기</button>
		</form>
	</body>
</html>