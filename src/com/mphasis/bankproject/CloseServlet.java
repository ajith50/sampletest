package com.mphasis.bankproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CloseServlet")
public class CloseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		String cUname =  (String) session.getAttribute("Uname");
		
		DbAdmin D1 = new DbAdmin();
		 D1.closeacc(cUname);
		
//		if(success==1) 
//			{
//				response.sendRedirect("FirstPage.html");
//			
//			}
//		else {
//			response.sendRedirect("FailAccno.html");
//		}
	}

}
