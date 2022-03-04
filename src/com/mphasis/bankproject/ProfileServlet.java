package com.mphasis.bankproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		String cUname =  (String) session.getAttribute("Uname");
		
		DbAdmin DB = new DbAdmin();
		List<accounts> acc = DB.profile(cUname);
		
		
		PrintWriter out= response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");out.println("<link rel=\"stylesheet\" href=\"mystyle.css\">");out.println("</HEAD>");
		out.println("<body  bgcolor=\"lightblue\">");
		out.println("<table class = \"styled-table\" border = 1 width = 50% height = 50%><centre>");
		out.println("<b><thead><tr class=\"active-row1\"><th>ACC NO</th><th>CNAME</th><th>USERNAME</th><th>BALANCE</th></tr></b></thead>");
		
		accounts A1 = acc.get(0);
		out.println("<tbody><tr class=\"active-row2\"><td>"+A1.getAccno()+"</td><td>"+A1.getcName()+"</td><td>"+A1.getcUname()+"</td>"
				+ "<td> "+A1.getCbal()+"</td></tr></tbody>");
		out.println("<table>");
		out.println("<br><form action=\"HomePage.html\" ><button class=\"button\">Back To Home</button></form>");
		out.println("</body>");
		out.println("</HTML>");
		

		
		
		
	}

}
