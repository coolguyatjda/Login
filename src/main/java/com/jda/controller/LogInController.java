package com.jda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jda.dao.DatabaseUtil;
import com.jda.model.UserModel;

public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel user = DatabaseUtil.fetchData(request.getParameter("email"), request.getParameter("password"));
		if (user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either email or password is wrong!</font>");
			dispatcher.include(request, response);
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeRedirectUrl("Home.jsp"));
			dispatcher.forward(request, response);
		}
	}
}
