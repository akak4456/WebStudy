package com.adele.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adele.book.model.vo.Book;
import com.adele.book.service.BookService;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/book/list.do")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bService = new BookService();
		List<Book> books = bService.selectAllBook();
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("books", books);
		request.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(request, response);
	}

}
