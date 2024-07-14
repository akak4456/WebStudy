package com.adele.member.controller;

import com.adele.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/remove.kh")
public class RemoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String memberId = request.getParameter("memberId");
            // 세션에 있는 값이랑 같은지 체크 후 비즈니스 로직 진행
            HttpSession session = request.getSession();
            String sMemberId = (String) session.getAttribute("memberId");
            if (sMemberId != null && sMemberId.equals(memberId)) {
                MemberService mService = new MemberService();
                int result = mService.deleteMember(memberId);
                if (result > 0) {
                    response.sendRedirect("/member/logout.kh");
                } else {
                    // 에러페이지 부르고
                    request.setAttribute("msg", "존재하지 않는 정보입니다.");
                    request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}
