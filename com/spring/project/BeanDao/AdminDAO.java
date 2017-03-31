package com.spring.project.BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.project.ConnectionManager;

//import com.inautix.template.ConnectionManager;
//import com.inautix.template.CustomerBean;

//import com.inautix.template.ConnectionManager;

public class AdminDAO {

	
	public int fillDetails(AdminBean ab){
		try
		{
			System.out.println("I am in dao");
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		String q = "select * from T_XBBNHCJ_Registration";
		String searchQuery2 = "insert into T_XBBNHCJ_Registration values(?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(searchQuery2);  
		stmt = conn.createStatement();
		
		
		 resultset = stmt.executeQuery(q);	
		 //resultset.last();
		 int n = 0,temp=0;
		while(resultset.next())
		{
			temp=resultset.getInt(1);
			if(temp>n)
		   n = temp;
		}
		
		//pstmt.setInt(1, ++n);
		pstmt.setInt(1,++n);
		pstmt.setString(2,ab.getName());
		pstmt.setString(3,ab.getMail_id());
		pstmt.setString(4,ab.getPwd());
		pstmt.setString(5,ab.getContact());
		pstmt.setInt(6,10);
		int i=pstmt.executeUpdate();
		System.out.println(i);
		return i;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int authenticate(AdminBean ab){
		try
		{
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		String q = "select * from T_XBBNHCJ_Registration";
		
		stmt = conn.createStatement();
		
		
		 resultset = stmt.executeQuery(q);	
		 
		 
		while(resultset.next())
		{
			//System.out.println("hi");
			String s1=resultset.getString(2);
			String s2=resultset.getString(4);
			//System.out.println(s1+" "+s2);
			if(s1.equals(ab.getName())&&s2.equals(ab.getPwd()))
					{
				
				 return resultset.getInt(1);
					}
		}
		
		
		
		return 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public AdminBean getCustomerDetails(int m)
	{
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		List CustList = null;
		 AdminBean a_Bean = new AdminBean();
		ResultSet resultset = null;
		System.out.println(m);
		String searchQuery = "SELECT *  from T_XBBNHCJ_Registration";
		try {
			 stmt = conn.createStatement();
				
			
			 resultset = stmt.executeQuery(searchQuery);	
			
			 //CustList = new ArrayList<CustomerBean>();
			
			while(resultset.next()) {
				if(resultset.getInt(1)==m)
				{
				//CustomerBean c_Bean = new CustomerBean();
				//a_Bean.setCustid(resultset.getInt(1));
				a_Bean.setName(resultset.getString(2));
				a_Bean.setMail_id(resultset.getString(3));
				a_Bean.setContact(resultset.getString(5));
				
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
		
		return a_Bean;
		
	}
	public ArrayList<AdminBean>  getCustomerDetailsAdmin()
	{
		Connection conn = ConnectionManager.access();
		Statement stmt = null;
		ArrayList<AdminBean> CustList =new ArrayList<AdminBean>();
		 
		ResultSet resultset = null;
		
		String searchQuery = "SELECT *  from T_XBBNHCJ_Registration";
		try {
			 stmt = conn.createStatement();
				
			
			 resultset = stmt.executeQuery(searchQuery);	
			
			 //CustList = new ArrayList<CustomerBean>();
			
			while(resultset.next()) {
				System.out.println("hi");
				AdminBean a_Bean = new AdminBean();
				System.out.println(resultset.getInt(1));
			a_Bean.setId(resultset.getInt(1));
				a_Bean.setName(resultset.getString(2));
				a_Bean.setMail_id(resultset.getString(3));
				a_Bean.setContact(resultset.getString(5));
				
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
	public int updateCredits(int id)
	{
		Connection conn = ConnectionManager.access();
		PreparedStatement preparedStmt =null;
		int set=0;
		
		try {
			String searchQuery  = "update T_XBBNHCJ_Registration set credits = 0 where id = ?";
			
			 preparedStmt = conn.prepareStatement(searchQuery);
		      
		      preparedStmt.setInt (1,id);
		      set =preparedStmt.executeUpdate();
              return set;
} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				
				
				if(preparedStmt != null)					
					preparedStmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		return set;
		
		
		
	}	
			
	public int addCredits(int id,int credit)
	{
		Connection conn = ConnectionManager.access();
		Statement stmt  =null;
		PreparedStatement preparedStmt =null;
		ResultSet rs =null;
		int set=0;
		int ch=0;
		
		try {
			stmt = conn.createStatement();
			String searchQuery  = "update T_XBBNHCJ_Registration set credits = ? where id = ?";
			String que = "select * from T_XBBNHCJ_Registration";
			rs = stmt.executeQuery(que);
			while(rs.next())
			{
				if(rs.getInt(1)==id)
				{
				ch=rs.getInt(6);break;
				}
			}
			credit=credit+ch;
			 preparedStmt = conn.prepareStatement(searchQuery);
		      
		      preparedStmt.setInt (1,credit);
		      preparedStmt.setInt (2,id);
		      set =preparedStmt.executeUpdate();
              return set;
} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				
				
				if(preparedStmt != null)					
					preparedStmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		return set;
		
		
		
	}			 
			
			 
			 
			
				
				
				
				
				
						
			
			
			
			
		
}
