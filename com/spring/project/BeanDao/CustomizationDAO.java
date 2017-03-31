
	package com.spring.project.BeanDao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.spring.project.ConnectionManager;

//import com.servlet.sample.ConnectionManager;
	public class CustomizationDAO {
		public int setCustomizationDetails(CustomizationBean cBean)
		{
			Connection conn = ConnectionManager.access();
			PreparedStatement stmt = null;
			List CustomList = null;
			int n=0;
			//ResultSet resultset = null;
			String searchQuery = "insert into T_XBBNHCJ_Customization values(?,?,?,?,?)";
			try {
				 stmt =  conn.prepareStatement(searchQuery);
				 stmt.setInt(1,cBean.getTempId());
					stmt.setString(2,cBean.getTitle());
					stmt.setString(3,cBean.getQuote());
					stmt.setString(4,cBean.getContact());
					stmt.setInt(5,cBean.getCustId());
				//System.out.println(cBean.getTitle()+" "+cBean.getQuote()+" "+cBean.getContact()+" "+cBean.getTempname());
				 n =  stmt.executeUpdate();	
				
				// CustomList = new ArrayList<CustomizationBean>();
				 
				return n;
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
			finally{
				try {
					
					//resultset.close();
					if(stmt != null)					
					stmt.close();				
					conn.commit();
					if(conn != null)
					conn.close();
				}			
				 catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
			return n;
			
		}
	public ArrayList<CustomizationBean>  getCustomizationDetailsAdmin()
	{
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		ArrayList<CustomizationBean> CustList =new ArrayList<CustomizationBean>();
		 
		ResultSet resultset = null;
		
		String searchQuery = "SELECT *  from T_XBBNHCJ_Customization";
		try {
			 stmt = conn.createStatement();
				
			
			 resultset = stmt.executeQuery(searchQuery);	
			
			 //CustList = new ArrayList<CustomerBean>();
			
			while(resultset.next()) {
				//System.out.println("hi");
				CustomizationBean a_Bean = new CustomizationBean();
				System.out.println(resultset.getInt(1));
			
				a_Bean.setTitle(resultset.getString(2));
				a_Bean.setQuote(resultset.getString(3));
				a_Bean.setContact(resultset.getString(4));
				a_Bean.setCustId(resultset.getInt(5));
				a_Bean.setTempId(resultset.getInt(1));
				CustList.add(a_Bean);
				
				
						
			}
			
			
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
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return CustList;
		
	}

	}


