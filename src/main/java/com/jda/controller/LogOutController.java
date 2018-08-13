package com.jda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.println("Successfully logged out!");
		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		out.println("<font color=blue>Successfully logged out!</font>");
		dispatcher.include(request, response);
	}
}
