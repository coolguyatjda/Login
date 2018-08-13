package com.jda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dao.DatabaseUtil;
import com.jda.model.UserModel;

public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel user = new UserModel();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		DatabaseUtil.addData(user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(response.encodeRedirectUrl("index.jsp"));
		requestDispatcher.forward(request, response);
	}
}
