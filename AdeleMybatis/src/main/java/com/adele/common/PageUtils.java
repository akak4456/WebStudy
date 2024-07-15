package com.adele.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageUtils {
    private final String ERROR_PAGE = "/WEB-INF/views/common/errorPage.jsp";
    public void moveErrorPage(HttpServletRequest request, HttpServletResponse response,
                              String errorMsg) throws ServletException, IOException {
        request.setAttribute("msg", errorMsg);
        RequestDispatcher view = request.getRequestDispatcher(ERROR_PAGE);
        view.forward(request, response);
    }
}
