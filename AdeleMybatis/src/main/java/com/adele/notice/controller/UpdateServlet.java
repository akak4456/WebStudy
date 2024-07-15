package com.adele.notice.controller;

import com.adele.common.PageUtils;
import com.adele.notice.model.service.NoticeService;
import com.adele.notice.model.vo.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/update.kh")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청이면 공지사항 수정 페이지 이동
        // 수정하려는 내용이 안보이기 때문에 보이도록 해줌
        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
        NoticeService nService = new NoticeService();
        Notice notice = nService.selectOneByNo(noticeNo);
        request.setAttribute("notice", notice);
        request.getRequestDispatcher("/WEB-INF/views/notice/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청이면 공지사항 수정 진행
        // UPDATE NOTICE_TBL SET NOTICE_SUBJECT = #{noticeSubject}, NOTICE_CONTENT = #{noticeContent}
        // WHERE NOTICE_NO = #{noticeNo}
        PageUtils pu = new PageUtils();
        String errorPage = "/WEB-INF/views/common/errorPage.jsp";
        try {
            request.setCharacterEncoding("UTF-8");
            int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
            String noticeSubject = request.getParameter("noticeSubject");
            String noticeContent = request.getParameter("noticeContent");
            Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
            NoticeService nService = new NoticeService();
            int result = nService.updateNotice(notice);
            if (result > 0) {
                response.sendRedirect("/notice/list.kh");
            } else {
                String errorMsg = "공지사항 수정이 완료되지 않았습니다.";
                pu.moveErrorPage(request, response, errorMsg);
            }
        } catch (Exception e) {
            pu.moveErrorPage(request, response, e.getMessage());
        }
    }
}
