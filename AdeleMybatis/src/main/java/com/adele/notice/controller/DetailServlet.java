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

@WebServlet("/notice/detail.kh")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtils pu = new PageUtils();
        String pageUrl = "/WEB-INF/views/common/errorPage.jsp";
        try {
            int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
            NoticeService nService = new NoticeService();
            Notice notice = nService.selectOneByNo(noticeNo);
            if(notice != null) {
                // detail.jsp 페이지로 이동
                request.setAttribute("notice", notice);
                request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
            } else {
                String errorMsg = "존재하지 않는 정보입니다.";
                pu.moveErrorPage(request, response, pageUrl, errorMsg);
            }
        } catch (Exception e) {
            pu.moveErrorPage(request, response, pageUrl, e.getMessage());
        }
    }
}
