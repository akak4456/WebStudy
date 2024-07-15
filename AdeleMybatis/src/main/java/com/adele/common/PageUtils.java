package com.adele.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageUtils {
    public void moveErrorPage(HttpServletRequest request, HttpServletResponse response,
                              String pageUrl, String errorMsg) throws ServletException, IOException {
        request.setAttribute("msg", errorMsg);
        RequestDispatcher view = request.getRequestDispatcher(pageUrl);
        view.forward(request, response);
    }
}
