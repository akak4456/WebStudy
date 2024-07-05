package com.adele.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operand1 = request.getParameter("operand1");
		String opcode = request.getParameter("opcode");
		String operand2 = request.getParameter("operand2");
		int op1 = Integer.parseInt(operand1);
		int op2 = Integer.parseInt(operand2);
		int result = 0;
		switch(opcode) {
		case "+":
			result = op1 + op2;
			break;
		case "-":
			result = op1 - op2;
			break;
		case "*":
			result = op1 * op2;
			break;
		case "/":
			result = op1 / op2;
			break;
		case "%":
			result = op1 % op2;
			break;
		}
		request.setAttribute("operand1", operand1);
		request.setAttribute("opcode", opcode);		
		request.setAttribute("operand2", operand2);
		request.setAttribute("opresult", result);
		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
	} 

}
