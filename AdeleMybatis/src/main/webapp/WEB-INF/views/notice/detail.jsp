<%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 2024-07-15
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>공지사항 상세</title>
    </head>
    <body>
        <span>글번호 : ${notice.noticeNo}</span>
        <span>글쓴이 : ${notice.noticeWriter}</span>
        <span>작성일 : ${notice.regDate}</span>
        <span>조회수 : ${notice.viewCount}</span><br>
        <span>글제목 : ${notice.noticeSubject}</span><br>
        <span>글내용 : ${notice.noticeContent}</span><br>
        <a href="#" onclick="goBack(); ">뒤로가기</a>
        <a href="/notice/update.kh?noticeNo=${notice.noticeNo}">수정하기</a>
        <a href="#" onclick="checkDelete(); ">삭제하기</a>
        <script>
            function checkDelete() {
                if(confirm("정말 삭제 하시겠습니까?")) {
                    location.href = "/notice/delete.kh?noticeNo=${notice.noticeNo}";
                }
            }
            function goBack() {
                history.go(-1);
            }
        </script>
    </body>
</html>
