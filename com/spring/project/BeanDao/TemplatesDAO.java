package com.spring.project.BeanDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.spring.project.ConnectionManager;

//import com.servlet.sample.ConnectionManager;
public class TemplatesDAO {
	
public TemplatesBean getTemplateDetails(String m)
{
	Connection conn = ConnectionManager.access();
	Statement stmt = null;
	//List TempList = null;
	TemplatesBean t_Bean = new TemplatesBean();
	ResultSet resultset = null;
	String searchQuery = "SELECT *  from T_XBBNHCJ_Templates";
	try {
		 stmt = conn.createStatement();
			
		
		 resultset = stmt.executeQuery(searchQuery);	
		
		 //TempList = new ArrayList<TemplatesBean>();
		 
		while(resultset.next()) {
			if(resultset.getString(2).compareTo(m)==0)
			{
			
			t_Bean.setTempid(resultset.getInt(1));
			t_Bean.setTempname(resultset.getString(2));
			t_Bean.setPvotes(resultset.getInt(3));
			t_Bean.setNvotes(resultset.getInt(4));
			t_Bean.setPrice(resultset.getFloat(6));
			//TempList.add(t_Bean);
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
	return t_Bean;
	
}

public int vote(TemplatesBean tb)
{
	Connection conn = ConnectionManager.access();
	
	int set =0;
	PreparedStatement preparedStmt = null;
	String searchQuery=null;
	try {
		 
			
		
		 
		
		 
		 
		
			searchQuery  = "update T_XBBNHCJ_Templates set p_votes = ? ,n_votes=? where code = ?";
			
			preparedStmt = conn.prepareStatement(searchQuery);
		      preparedStmt.setInt (1,tb.getPvotes());
		      preparedStmt.setInt (2,tb.getNvotes());
		      preparedStmt.setInt (3,tb.getTempid());
		     set= preparedStmt.executeUpdate();
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
public ArrayList<TemplatesBean> getTemplateDetailsAdmin()
{
	Connection conn = ConnectionManager.access();
	Statement stmt = null;
	ArrayList<TemplatesBean> TempList = new ArrayList<TemplatesBean>();
	//Iterator it =TempList.iterator();
	//TemplatesBean t_Bean = new TemplatesBean();
	ResultSet resultset = null;
	String searchQuery = "SELECT *  from T_XBBNHCJ_Templates";
	try {
		 stmt = conn.createStatement();
			
		
		 resultset = stmt.executeQuery(searchQuery);	
		
		 //TempList = new ArrayList<TemplatesBean>();
		 
		while(resultset.next()) {
			TemplatesBean t_Bean = new TemplatesBean();
			//System.out.println("h1");
			t_Bean.setTempid(resultset.getInt(1));
			t_Bean.setTempname(resultset.getString(2));
			t_Bean.setPvotes(resultset.getInt(3));
			t_Bean.setNvotes(resultset.getInt(4));
			t_Bean.setPrice(resultset.getFloat(6));
			TempList.add(t_Bean);
			
					
		}
		
		
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
	return TempList;
}

public int remove(int id)
{
	Connection conn = ConnectionManager.access();
	
	int set =0;
	PreparedStatement preparedStmt = null;
	String searchQuery=null;
	try {
		 
			
		
		 
		
		 
		 
		
			searchQuery  = "delete from  T_XBBNHCJ_Templates  where code = ?";
			
			preparedStmt = conn.prepareStatement(searchQuery);
		     
		      preparedStmt.setInt (1,id);
		     set= preparedStmt.executeUpdate();
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
