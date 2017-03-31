package com.spring.project.BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.project.ConnectionManager;

//import com.servlet.sample.ConnectionManager;

public class PurchaseDAO {
/*public float doPurchase(int tid){
	Connection conn = ConnectionManager.access();
	Statement stmt = null;--
	//List TempList = null;
	//t_DAO= TemplatesDAO new TemplatesDAO();
	TemplatesDAO t_DAO = new TemplatesDAO();
	ResultSet resultset = null;
	String searchQuery = "SELECT *  from T_XBBNHCJ_Templates";
	 TemplatesBean tempB = t_DAO.getTemplateDetails(tid);
	 float price = tempB.getPrice();
	try {
		 stmt = conn.createStatement();
			
		
		 resultset = stmt.executeQuery(searchQuery);	
		
		 //TempList = new ArrayList<TemplatesBean>();
		 
		while(resultset.next()) {
			if(resultset.getInt(1)==m)
			{
			PurchaseBean p_Bean = new PurchaseBean();
			p_Bean.setTempid(resultset.getInt(1));
			//p_Bean.setTempname(resultset.getString(2));
			//p_Bean.setPvotes(resultset.getInt(3));
			//p_Bean.setNvotes(resultset.getInt(4));
			//p_Bean.setPrice(resultset.getFloat(6));
			TempList.add(p_Bean);
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
	return price;
	
}
*/
public int updatePurchase(PurchaseBean pb) {
	
	Connection conn = ConnectionManager.access();
	PreparedStatement pstmt = null;
	
	String searchQuery2 = "insert into T_XBBNHCJ_Purchase values(?,?,?,?)";
	
	try{
		 
		
		
		
		pstmt=conn.prepareStatement(searchQuery2);  
		
		  
		int n=0;
		
	   
		
	   pstmt.setInt(1,pb.getCust_id());  
		pstmt.setInt(2,pb.getCredits_spent());  
		pstmt.setInt(3,pb.getCredits_earned());
		
		pstmt.setFloat(4,pb.getTotal_price());
		n=pstmt.executeUpdate();  
		return n;
		  /* if(cr!=0)
		   {
			   pstmt=conn.prepareStatement(searchQuery3);
				pstmt.setInt(1,0);//1 specifies the first parameter in the query  
				pstmt.setInt(2,uid);  
				pstmt.executeUpdate();  
		   }
		   else
		   {int c=0;
			   stmt = conn.createStatement();
				
				String searchQuery4 = "select * from T_XBBNHCJ_CustomerDetail";
				 resultset = stmt.executeQuery(searchQuery4);	
				 while(resultset.next())
				 {
					 if(resultset.getInt(1)==uid)
					 {
					    c = resultset.getInt(4);
					    break;
					 }
				 }
				 c=c+cr1;
			   pstmt=conn.prepareStatement(searchQuery3);
				pstmt.setInt(1,c);//1 specifies the first parameter in the query  
				pstmt.setInt(2,uid);  
				pstmt.executeUpdate();  
		   }
		*/
		
	}
	
       catch (SQLException e) {
		
		e.printStackTrace();
	}	
	finally{
		try {
			
			//resultset.close();
			if(pstmt != null)					
			pstmt.close();	
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
	return 0;
	
	
}

public int getCredits(int uid) {
	//Connection conn = ConnectionManager.access();
	//Statement stmt = null;
	//List TempList = null;
	CustomerDAO c_DAO= new CustomerDAO();
	//ResultSet resultset = null;
	String searchQuery = "SELECT *  from T_XBBNHCJ_Templates";
	CustomerBean c_Bean = c_DAO.getCustomerDetails(uid);		
	 
	 int credit = c_Bean.getCredits();
	return credit;
}
}
