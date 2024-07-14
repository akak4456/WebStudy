<%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 2024-07-12
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>공지사항 등록</title>
    </head>
    <body>
        <form action="/notice/insert.kh" method="post">
           <fieldset>
               <legend>공지사항 등록</legend>
               제목 : <input type="text" name="noticeSubject"><br>
               내용 : <textarea rows="10" cols="40" name="noticeContent"></textarea><br>
           </fieldset>
            <input type="submit" value="등록">
        </form>
    </body>
</html>
