package com.mphasis.bankproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DbAdmin {

	Connection con=null;
		
		public DbAdmin() 
		{
			try 
			{
				 Class.forName("oracle.jdbc.driver.OracleDriver");

					//Establish connection

					 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");

			}
			catch(Exception E)
			{
				E.printStackTrace();
			}
		}
		public int insertacc(String cName,String cNumber,String cUname,String ePsw,String cbal ) 
		{
			
//			System.out.println(eEmpno + " " + eEname);
			
			try 
			{
				PreparedStatement stmt = con.prepareStatement("INSERT INTO bankaccounts VALUES (BANK_ID.nextval,?,?,?,?,?)");
				
				stmt.setString(1,cName);
				stmt.setString(2,cNumber);
				stmt.setString(3,cUname);
				stmt.setString(4,ePsw);
				stmt.setString(5,cbal );
				
				 return stmt.executeUpdate();
				
				
				
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			return 0 ;
			}
		
		public void deposit(String cUname,int depamt) {
			try 
			{
				PreparedStatement stmt = con.prepareStatement("update bankaccounts set balance = balance + ? where username = ?");
				
				stmt.setInt(1,depamt);
				
				stmt.setString(2,cUname);
				
				
				 stmt.executeUpdate();
				
				
				
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
			
			public int withdraw(String cUname,int wthamt) {
				try 
				{
					PreparedStatement stmt = con.prepareStatement("update bankaccounts set balance = balance - ? where username = ? AND BALANCE > ?");
					
					stmt.setInt(1,wthamt);
					
					stmt.setString(2,cUname);
					
					stmt.setInt(3,wthamt);
					
					return stmt.executeUpdate();
					
					
					
					
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				return 0;
		}
			
			
			public int transfer(int accno,int tfamt) {
				try 
				{
					
					
			PreparedStatement stmt = con.prepareStatement("update bankaccounts set balance = balance + ? where accno = ?");
					
					stmt.setInt(1,tfamt);
					
					stmt.setInt(2,accno);
					
				
					 return stmt.executeUpdate();
					
					 	
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				return 0 ;
			}
			
			
			public List<accounts> profile(String uname)
			{
				List<accounts> accs = new ArrayList<accounts>();
				
				
				try 
				{
					PreparedStatement stmt = con.prepareStatement("SELECT ACCNO,CNAME,USERNAME,BALANCE FROM bankaccounts where username = ? ");
					
					stmt.setString(1, uname);
					
				ResultSet rs =stmt.executeQuery();
//				System.out.println(rs.next());
//				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				while(rs.next())
				{
					
					accounts acc =  new accounts();
					acc.setAccno(rs.getInt(1));
					acc.setcName(rs.getString(2));
					acc.setcUname(rs.getString(3));
					acc.setCbal(rs.getInt(4));
					
					accs.add(acc);
			
				}
				}
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			return accs;	
			}
			
			public int closeacc(String cUname ) 
			{
				
				try 
				{
					
					PreparedStatement stmt3 = con.prepareStatement("DELETE FROM BANKACCOUNTS where username  = ?");
					
					
					
					stmt3.setString(1,cUname);
				
					 return stmt3.executeUpdate();
				
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				return 0 ;
				}
			
}

	
	

