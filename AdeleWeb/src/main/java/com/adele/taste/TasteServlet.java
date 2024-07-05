package com.adele.taste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasteServlet
 */
@WebServlet("/TasteServlet")
public class TasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personName = request.getParameter("person-name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");
		
		Map<String, String> colorMap = new HashMap<>();
		colorMap.put("red", "빨강");
		colorMap.put("blue", "파랑");
		colorMap.put("yellow", "노랑");
		colorMap.put("green", "초록");
		
		Map<String, String> animalMap = new HashMap<>();
		animalMap.put("puppy", "강아지");
		animalMap.put("kitty", "고양이");
		animalMap.put("elephant", "코끼리");
		animalMap.put("lion", "사자");
		
		Map<String, String> foodMap = new HashMap<>();
		foodMap.put("jjm", "짜장면");
		foodMap.put("jjb", "짬뽕");
		foodMap.put("tsy", "탕수육");
		foodMap.put("mpdb", "마파두부");
		foodMap.put("pbc", "팔보채");
		
		String foodStr = "";
		for(String food : foods) {
			foodStr += foodMap.get(food) + ", ";
		}
		
		request.setAttribute("userName", personName);
		request.setAttribute("color", colorMap.get(color));
		request.setAttribute("pet", animalMap.get(animal));
		request.setAttribute("foodStr", foodStr);
		request.getRequestDispatcher("/taste/tasteResult.jsp").forward(request, response);
		
//		response.setContentType("text/html;charset=UTF-8");
	}

}
