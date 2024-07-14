<%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 2024-07-12
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>공지사항</title>
        <style>
            table {
                width: 800px;
                border: 1px solid black;
                border-collapse: collapse;
            }
            th {
                background-color: #ccc;
            }
            th, td {
                border :1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>공지사항 목록</h1>
        <table>
            <tr>
                <th>글번호</th>
                <th>글제목</th>
                <th>글쓴이</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            <c:forEach var="notice" items="${nList}">
            <tr>
                <td>${notice.noticeNo}</td>
                <td>${notice.noticeSubject}</td>
                <td>${notice.noticeWriter}</td>
                <td>${notice.regDate}</td>
                <td>${notice.viewCount}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
