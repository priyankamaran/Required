
	package com.spring.project.BeanDao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.spring.project.ConnectionManager;

//import com.servlet.sample.ConnectionManager;
	public class CustomUrlDAO {
	public boolean getCustomUrlDetails(int id,String url)
	{
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		List CustomList = null;
		int index=0;
		ResultSet resultset = null;
		
		String searchQuery = "SELECT *  from T_XBBNHCJ_CustomUrl";
		try {
			 stmt = conn.createStatement();
			 resultset = stmt.executeQuery(searchQuery);	
				
			 
			while(resultset.next()) {
			
			index=resultset.getInt(1);
			}
			 resultset = stmt.executeQuery(searchQuery);	
			
			 //CustomList = new ArrayList<CustomUrlBean>();
			 
			while(resultset.next()) {
				//System.out.println(resultset.getString(3));
				String s=resultset.getString(3);
				//System.out.println(s);
				if(s.compareTo(url)==0)
				{
					
				return true;
				
				//CustomList.add(cu_Bean);
				}
				
						
			}
			searchQuery = "insert into T_XBBNHCJ_CustomUrl values(?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(searchQuery);
		      preparedStmt.setInt (1,++index);
		      preparedStmt.setInt (2,id);
		      preparedStmt.setString (3,url);
			
		      preparedStmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
				//return false;
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return false;
		}





	



	

	public CustomUrlBean getChoiceUrl(int id,String name) {
		
	String url = "http://";
		Connection conn = ConnectionManager.access();
		CustomUrlBean uBean=new CustomUrlBean(); 
		Statement stmt1 = null;
		Statement stmt2 = null;
		ResultSet resultset1 = null;
		ResultSet resultset2= null;
		String searchQuery1  = "select * from T_XBBNHCJ_Registration";
		String searchQuery2  = "select * from T_XBBNHCJ_Templates";
		try {
			 stmt1 = conn.createStatement();
			 stmt2 = conn.createStatement();
			
			 resultset1 = stmt1.executeQuery(searchQuery1);	
			 resultset2= stmt2.executeQuery(searchQuery2);
			 
			 while(resultset2.next()) {
					if(resultset2.getInt(1)==id)
					
					{
						uBean.setDurl(resultset2.getString(5));
						url = url+resultset2.getString(4);
						url = url+"/";
						break;
					}
					
					
			 }
			 
			 while(resultset1.next()) {
				
					if(resultset1.getString(2).compareTo(name)==0)
					
					{
						url= url+resultset1.getInt(1);
					    url = url+"/";
						url = url+name;
						
						break;
					}
					
					
			 }
			 uBean.setUrl(url);
			 return uBean;
		
	}
catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				
				resultset1.close();
				resultset2.close();
				if(stmt1 != null)					
				stmt1.close();
				if(stmt2 != null)					
					stmt2.close();
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		return uBean;
		
	}





	}
	
	

