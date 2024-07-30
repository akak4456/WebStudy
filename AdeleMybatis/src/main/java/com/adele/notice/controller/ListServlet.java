package com.adele.notice.controller;

import com.adele.notice.model.service.NoticeService;
import com.adele.notice.model.vo.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notice/list.kh")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoticeService nService = new NoticeService();
        int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
        List<Notice> nList = nService.selectAllNotice(currentPage);
        int totalCount = nService.getTotalCount();
        int recordCountPerPage = 10;
        int naviTotalCount = 0;
        if(totalCount % recordCountPerPage > 0) {
            naviTotalCount = totalCount / recordCountPerPage + 1;
        } else {
            naviTotalCount = totalCount / recordCountPerPage;
        }
        int naviCountPerPage = 10;
        int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
        int endNavi = startNavi + naviCountPerPage - 1;
        if(endNavi > naviTotalCount) {
            endNavi = naviTotalCount;
        }
        if(!nList.isEmpty()) {
            // list.jsp로 이동
            request.setAttribute("startNavi", startNavi);
            request.setAttribute("endNavi", endNavi);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("naviTotalCount", naviTotalCount);
            request.setAttribute("nList", nList);
            request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
        } else {
            // error.jsp로 이동
            request.setAttribute("msg", "존재하지 않는 정보입니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}
