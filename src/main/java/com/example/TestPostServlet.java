package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestPostServlet", urlPatterns = "/testPost")
public class TestPostServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/testPostPage.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String paramTestPost = request.getParameter("test_post");
		request.getSession().setAttribute("someSessionAttrName", "!!MODIFIED!! " + paramTestPost + " !!MODIFIED!!");

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/testPostPage.jsp");
		rd.forward(request, response);
	}
}
