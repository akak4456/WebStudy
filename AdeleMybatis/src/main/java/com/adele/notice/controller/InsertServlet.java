package com.adele.notice.controller;

import com.adele.notice.model.service.NoticeService;
import com.adele.notice.model.vo.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/insert.kh")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String noticeSubject = request.getParameter("noticeSubject");
            String noticeContent = request.getParameter("noticeContent");
            String noticeWriter = (String) request.getSession().getAttribute("memberId");
            Notice notice = new Notice(noticeSubject, noticeContent, noticeWriter);
            NoticeService noticeService = new NoticeService();
            int result = noticeService.insertNotice(notice);
            if(result > 0) {
                // 리스트
                response.sendRedirect("/notice/list.kh");
            } else {
                request.setAttribute("msg", "공지 글이 정상등록되지 않았습니다.");
                request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}
