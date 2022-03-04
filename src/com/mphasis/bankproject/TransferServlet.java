package com.mphasis.bankproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		

		String cUname =  (String) session.getAttribute("Uname");
		
		String tfamt = request.getParameter("amt");
		
		String accno = request.getParameter("acc");
		
		
		DbAdmin D1 = new DbAdmin();
		int success = D1.withdraw(cUname, Integer.parseInt(tfamt));
		
		if(success==1) 
			{
			int success2=D1.transfer(Integer.parseInt(accno), Integer.parseInt(tfamt));
				if(success2==1) 
				{
					response.sendRedirect("Success.html");
				}
				else 
				{
					response.sendRedirect("Transfail.html");}
				}
			
		else
		{
			response.sendRedirect("Transfail.html");
		}
		
}
}


