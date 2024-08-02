<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세조회</title>
	</head>
	<body>
		<h1>공지사항 상세 조회</h1>
		<ul>
			<li>
				<label>번호</label>
				<span>${notice.noticeNo }</span>
				<input type="hidden" id="noticeNo" value="${notice.noticeNo }">
			</li>
			<li>
				<label>작성일자</label>
				<span>${notice.noticeDate }</span>
			</li>
			<li>
				<label>제목</label>
				<span>${notice.noticeSubject }</span>
			</li>
			<li>
				<label>내용</label>
				<span>${notice.noticeContent }</span>
			</li>
		</ul>
		<!--  댓글 등록 -->
		<form action="/reply/insert.kh" method="post">
			<input type="hidden" name="refNoticeNo" value="${notice.noticeNo }">
			<table width="500" border="1">
				<tr>
					<td>
						<input type="text" name="replyContent" id="" size="50">
					</td>
					<td>
						<input type="submit" value="완료">
					</td>
				</tr>
			</table>
		</form>
		<!--  댓글 목록 -->
		<table width="550" border="1">
			<c:forEach items="${rList }" var="reply">
				<tr>
					<td>${reply.replyWriter }</td>
					<td>${reply.replyContent }</td>
					<td>${reply.rCreateDate }</td>
					<td>
						<a href="#">수정</a>
						<a href="#">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>
		<button type="button" onclick="showUpdateForm();">수정하기</button>
		<button type="button" onclick="noticeDelete();">삭제하기</button>
		<button type="button" onclick="showNoticeList();">목록으로 이동</button>
		<script>
			function showUpdateForm() {
				location.href="/notice/update.kh?noticeNo=${notice.noticeNo}";
			}
			function noticeDelete() {
				if(confirm("정말로 삭제하시겠습니까?")) {
					var inputTag = document.querySelector("#noticeNo");
					location.href = "/notice/delete.kh?noticeNo=" + inputTag.value;
				}
			}
			function showNoticeList() {
				location.href="/notice/list.kh";
			}
		</script>
	</body>
</html>