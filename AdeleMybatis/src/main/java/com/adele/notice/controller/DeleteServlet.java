package com.adele.notice.controller;

import com.adele.common.PageUtils;
import com.adele.notice.model.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/delete.kh")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtils pu = new PageUtils();
        try {
            int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
            NoticeService nService = new NoticeService();
            int result = nService.deleteNotice(noticeNo);
            if(result > 0) {
                response.sendRedirect("/notice/list.kh");
            } else {
                String errorMsg = "삭제가 완료되지 않았습니다.";
                pu.moveErrorPage(request, response, errorMsg);
            }
        } catch (Exception e) {
            pu.moveErrorPage(request ,response ,e.getMessage());
        }
    }
}
