package com.mphasis.bankproject;

import java.io.PrintWriter;
import java.util.List;

public class Dummy {
	public static void main (String[] args) {
		
//		String userName = "aiyam";
//		String passWord = "12345";
//		
//		LogAuthenticate A1 = new LogAuthenticate();
//		boolean result = A1.authenticateUser(userName,passWord);
//		System.out.println(result);
		
		DbAdmin D1 = new DbAdmin();
		List<accounts> acc = D1.profile("aiyam123");
		System.out.println(acc.size());
		accounts A1 = acc.get(0);
		
		System.out.println("<tr><td>"+A1.getAccno()+"</td><td>"+A1.getcName()+"</td><td>"+A1.getcUname()+"</td>"
				+ "<td> "+A1.getCbal()+"</td></tr>");
		
//		System.out.println(DY.authenticateUser("vishal1999" ,"password"));
		
	}

}
