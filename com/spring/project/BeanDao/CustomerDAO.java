
	package com.spring.project.BeanDao;

	import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.spring.project.ConnectionManager;


	public class CustomerDAO {
	public CustomerBean getCustomerDetails(int m)
	{
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		List CustList = null;
		 CustomerBean c_Bean = new CustomerBean();
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from T_XBBNHCJ_Registration";
		try {
			 stmt = conn.createStatement();
				
			
			 resultset = stmt.executeQuery(searchQuery);	
			
			 //CustList = new ArrayList<CustomerBean>();
			
			while(resultset.next()) {
				if(resultset.getInt(1)==m)
				{
				//CustomerBean c_Bean = new CustomerBean();
				c_Bean.setCustid(resultset.getInt(1));
				//System.out.println(resultset.getString(2));
				c_Bean.setCustname(resultset.getString(2));
				c_Bean.setMailid(resultset.getString(3));
				c_Bean.setCredits(resultset.getInt(6));
				
				//CustList.add(c_Bean);
				}
						
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
		
		return c_Bean;
		
	}



	}


