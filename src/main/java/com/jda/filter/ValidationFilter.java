package com.jda.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.cj.util.StringUtils;

public class ValidationFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String passWord = request.getParameter("password");
//		String reEnter = request.getParameter("reEnterPassword");
//			if(passWord.equals(reEnter)){
//				RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
//				PrintWriter out = response.getWriter();
//				out.println("<font color=red>Password Do Not Match</font>");
//				dispatcher.include(request, response);				
//				return;
//			}
			Pattern emailPatern = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
			Pattern passwordPattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
			Matcher m = emailPatern.matcher(email);
			Matcher p = passwordPattern.matcher(passWord);
			if(!m.matches()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Please Enter Valid Email</font>");
				dispatcher.include(request, response);
				//return;
			}  else if(!p.matches()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Please Enter Valid PassWordl</font>");
				dispatcher.include(request, response);
				//return;
			}else if(!(phoneNumber.length() == 10 && StringUtils.isStrictlyNumeric(phoneNumber))){
				RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Please Enter Valid PhoneNumber</font>");
				dispatcher.include(request, response);
				//return;
		}else{
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
