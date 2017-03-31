package com.spring.project.BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.spring.project.ConnectionManager;

public class MyOrderDAO {
	public boolean updateOrder(String uname,String tname,int price)
	{
		Connection conn = ConnectionManager.access();
		PreparedStatement pstmt = null;
		try{
		
		String searchQuery2 = "insert into T_XBBNHCJ_MyOrder values(?,?,?)";
		pstmt=conn.prepareStatement(searchQuery2);  
		pstmt.setString(1,uname);
		pstmt.setString(2,tname);
		pstmt.setInt(3,price);
		
		int i=pstmt.executeUpdate();
		return true;
} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				
				
				if(pstmt != null)					
				pstmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		return false;
	}
	public MyOrderBean getOrder(String m)
	{
		MyOrderBean mbean = new MyOrderBean();
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from T_XBBNHCJ_MyOrder";
		try {
			 stmt = conn.createStatement();
				
			
			 resultset = stmt.executeQuery(searchQuery);	
			
			 //CustList = new ArrayList<CustomerBean>();
			
			while(resultset.next()) {
				if(resultset.getString(1).compareTo(m)==0)
				{
				//CustomerBean c_Bean = new CustomerBean();
				mbean.setUname(resultset.getString(1));
				//System.out.println(resultset.getString(2));
				mbean.setTname(resultset.getString(2));
				mbean.setPrice(resultset.getInt(3));
				//mbean.setCredits(resultset.getInt(4));
				
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
		
		return mbean;
		
	}

}
