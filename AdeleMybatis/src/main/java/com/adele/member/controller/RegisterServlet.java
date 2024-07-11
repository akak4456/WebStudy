package com.adele.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adele.member.model.service.MemberService;
import com.adele.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.kh")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.sendRedirect("/WEB-INF/views/member/register.jsp"); 이렇게 하면 안된다
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response); // 이렇게 해야 한다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String memberId 	= request.getParameter("member-id");
			String memberPw 	= request.getParameter("member-pw");
			String memberName 	= request.getParameter("member-name");
			String gender 		= request.getParameter("gender");
			String age 			= request.getParameter("age");
			String email 		= request.getParameter("email");
			String phone 		= request.getParameter("phone");
			String address 		= request.getParameter("address");
			String hobby 		= request.getParameter("hobby");
			Member member = new Member(memberId, memberPw, memberName, gender, Integer.parseInt(age), email, phone, address, hobby);
			MemberService mService = new MemberService();
			int result = mService.insertMember(member);
			if(result > 0) {
				response.sendRedirect("/");
			} else {
				request.setAttribute("msg", "회원가입이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
