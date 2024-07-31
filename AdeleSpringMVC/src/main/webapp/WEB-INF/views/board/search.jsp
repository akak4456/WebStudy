<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>자유게시판</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>첨부파일</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(sList) == 0 }">
					<tr>
						<td colspan="5">데이터가 존재하지 않습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${sList }" var="board">
						<tr>
							<td>${board.boardNo }</td>
							<td><a href="/board/detail.kh?boardNo=${board.boardNo }&currentPage=${currentPage}">${board.boardTitle }</a></td>
							<td>${board.boardWriter }</td>
							<td>${board.bCreateDate }</td>
							<td>X</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5" align="center">
					<c:url value="/board/search.kh" var="searchUrl">
						<c:param name="searchCondition" value="${searchCondition }"></c:param>
						<c:param name="searchKeyword" value="${searchKeyword }"></c:param>
					</c:url>
					<c:if test="${currentPage ne 1 }">
						<a href="${searchUrl}&page=1">&lt;&lt;</a>
					</c:if>
					<c:if test="${currentPage ne 1 }">
						<a href="${searchUrl}&page=${currentPage - 1 }">&lt;</a>
					</c:if>
					<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
						<c:if test="${currentPage eq p }">
							<span style="font-weight:bolder; font-size:30px">${p }</span>
						</c:if>
						<c:if test="${currentPage ne p }">
							<a href="${searchUrl}&page=${p }">${p }</a>
						</c:if>
					</c:forEach>
					<c:if test="${currentPage ne naviTotalCount}">
						<a href="${searchUrl}&page=${currentPage + 1 }">&gt;</a>
					</c:if>
					<c:if test="${currentPage ne naviTotalCount}">
						<a href="${searchUrl}&page=${naviTotalCount }">&gt;&gt;</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<form action="/board/search.kh" method="post">
						
						<select name="searchCondition">
							<option value="all" <c:if test="${searchCondition =='all' }">selected</c:if>>전체</option>
							<option value="writer" <c:if test="${searchCondition =='writer' }">selected</c:if>>작성자</option>
							<option value="title" <c:if test="${searchCondition =='title' }">selected</c:if>>제목</option>
							<option value="content" <c:if test="${searchCondition =='content' }">selected</c:if>>내용</option>
						</select>
						<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요" value="${searchKeyword }">
						<input type="submit" value="검색">
					</form>
				</td>
				<td>
					<a href="/board/register.kh">글쓰기</a>
				</td>
			</tr>
		</table>
		<script>
			var message = "${message}";
			if(message) {
				alert(message);
			}
		</script>
	</body>
</html>