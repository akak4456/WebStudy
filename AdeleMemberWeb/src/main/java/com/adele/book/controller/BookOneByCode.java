package com.adele.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adele.book.model.vo.Book;
import com.adele.book.service.BookService;

/**
 * Servlet implementation class BookOneByCode
 */
@WebServlet("/book/onebycode.do")
public class BookOneByCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookNo = request.getParameter("bookNo");
		BookService bService = new BookService();
		try {
			Book book = bService.selectBookOne(Integer.parseInt(bookNo));
			if(book != null) {
				request.setAttribute("book", book);
				request.getRequestDispatcher("/WEB-INF/views/book/one.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "조회 실패");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}

}
