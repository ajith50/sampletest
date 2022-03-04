package com.mphasis.bankproject;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class LogAuthenticate {

		public boolean authenticateUser(String userName, String passWord)
		{
			
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				//Establish connection

				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				PreparedStatement stmt = con.prepareStatement("select * from bankaccounts where username = ?");    
				stmt.setString(1, userName);    
				
				
				ResultSet rs = stmt.executeQuery();
				
		
				if(rs.next()) {
				
					String username = rs.getString(4);
					String password = rs.getString(5);
					
					
					if(username.equals(userName))
					{
						if(password.equals(passWord)) 
						{
							return true;
						}
						else {
							System.out.println("Incorrect password");
						}
					}
					
				}
				else {
					System.out.println("User not found!! ");
				}
					
				
			}
			catch(Exception E)
			{
				E.printStackTrace();
			}
			return false;
		}
		
		
	}


