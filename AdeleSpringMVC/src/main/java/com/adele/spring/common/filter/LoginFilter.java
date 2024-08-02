package com.adele.spring.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns= {"/board/*", "/member/mypage.kh"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터 코드가 변경되면 이전 필터를 파괴하는 메소드
		System.out.println("로그인 필터 종료");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		// 클라이언트 요청 <-> 필터(필터 코드 실행) <-> DispatcherServlet
		// 1) HttpServletRequest, HttpServletResponse으로 다운캐스팅
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		// 2) 세션 얻어오기
		HttpSession session = req.getSession();
		
		// 3) 로그인 여부 확인
		// if문 필요, 로그인되었으면 세션에 뭐가있지?, 그게 널이 아니어야 로그인된거겠지,
		// 널이면 로그인이 안되어있으니 로그인페이지 이동시켜야겠네
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			chain.doFilter(request, response);
		} else {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter writer = resp.getWriter();
			writer.println("<script>alert('로그인 정보가 존재하지 않습니다.');location.href='/'</script>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 서버가 동작하면 필터 코드가 변경되었을 때 필터가 생성됨
		System.out.println("로그인 필터 생성");
	}

}
