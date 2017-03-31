package com.spring.project.BeanDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.spring.project.ConnectionManager;

public class BankDAO 
{
public int checkDetails(BankBean b)
{
	try
	{
		//System.out.println("I am in dao");
	Connection conn = ConnectionManager.access();
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	//String q = "select * from T_XBBNHCJ_Registration";
	String searchQuery2 = "select * from T_XBBNHCJ_Bank ";
	pstmt=conn.prepareStatement(searchQuery2);  
	stmt = conn.createStatement();
	
	
	 resultset = stmt.executeQuery(searchQuery2);	
	 //resultset.last();
	 int n = 0,temp=0;
	while(resultset.next())
	{
	
		if(resultset.getString(1).compareTo(b.getName())==0&&resultset.getString(2).compareTo(b.getAccountNumber())==0&&resultset.getString(3).compareTo(b.getCardNumber())==0&&resultset.getInt(4)==b.getPin()&&resultset.getFloat(4)==b.getAmount())
			{
			
		}
	  
	}
	
	//pstmt.setInt(1, ++n);
	
	
	int i=;
	System.out.println(i);
	return i;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return 0;
	
}
}
