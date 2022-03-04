package com.mphasis.bankproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
//		System.out.println("works");
		String cUname =  (String) session.getAttribute("Uname");
		
		String depamt = request.getParameter("amt");
		
		
		DbAdmin D1 = new DbAdmin();
		int success = D1.withdraw(cUname, Integer.parseInt(depamt));
		
		if(success==1) {
			response.sendRedirect("Success.html");
		}
		else {
			response.sendRedirect("TransFail.html");
		}
		
	}

}
