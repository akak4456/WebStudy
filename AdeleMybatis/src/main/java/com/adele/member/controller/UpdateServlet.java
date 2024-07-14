package com.adele.member.controller;

import com.adele.member.model.service.MemberService;
import com.adele.member.model.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/update.kh")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String hobby = request.getParameter("hobby");
            String memberId = request.getParameter("member-id");
            MemberService mService = new MemberService();
            Member member = new Member();
            member.setEmail(email);
            member.setPhone(phone);
            member.setAddress(address);
            member.setHobby(hobby);
            member.setMemberId(memberId);
            int result = mService.updateMember(member);
            if(result > 0) {
                response.sendRedirect("/member/mypage.kh");
            } else {
                request.setAttribute("msg", "정보수정이 완료되지 않았습니다.");
                request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }
}
