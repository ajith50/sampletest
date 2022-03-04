package com.mphasis.bankproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cName = request.getParameter("name");
		
		String cNumber = request.getParameter("cno");
		
		String cUname = request.getParameter("uname");
		
		String ePsw = request.getParameter("psw");
		
		String cbal = request.getParameter("amt");
		
		DbAdmin D1 = new DbAdmin();
		int success =  D1.insertacc(cName ,cNumber ,cUname ,ePsw ,cbal );
		if(success==1)
		{
			response.sendRedirect("LoginPage.html");
		}
		else 
		{
			response.sendRedirect("LoginPage.html");
		}

	}

}
