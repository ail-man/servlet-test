package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestGetServlet", urlPatterns = "/testGet")
public class TestGetServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");

		if (params == null || params.keySet().isEmpty()) {
			out.println("<h2>Params is absent! Please, add params to url, for example: </h2>");
			String exampleUrl1 = request.getRequestURL() + "?someParamName=someValue";
			String exampleUrl2 = request.getRequestURL() + "?singleValued1=one&singleValued2=two&singleValued3=three";
			String exampleUrl3 = request.getRequestURL() + "?multivalued[]=aaa&multivalued[]=bbb&multivalued[]=ccc";
			out.println("<a href='" + exampleUrl1 + "'/>" + exampleUrl1 + "</a><br/>");
			out.println("<a href='" + exampleUrl2 + "'/>" + exampleUrl2 + "</a><br/>");
			out.println("<a href='" + exampleUrl3 + "'/>" + exampleUrl3 + "</a><br/>");
		} else {
			for (String key : params.keySet()) {
				out.println("<br/>Param key: <b>" + key + "</b><br/>");

				String[] values = params.get(key);
				for (String val : values) {
					out.println("value: <b>" + val + "</b><br/>");
				}
			}
		}

		out.println("</html>");
	}

}
