package com.mphasis.bankproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("pwd");
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Uname",userName );
		
		LogAuthenticate A1 = new LogAuthenticate();
		boolean result = A1.authenticateUser(userName,passWord);
		
		if(result)
		{
			 response.sendRedirect("HomePage.html");
		}
		else {
			 response.sendRedirect("LogFail.html");
		}
	}
	}


