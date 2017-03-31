package com.spring.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	public static Connection access()
	{
		Connection con = null;
		try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("org.apache.derby.jdbc.ClientDriver");

		//con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	con=DriverManager.getConnection("jdbc:derby://172.24.18.118:1527/sample","user","pwd");


		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return con;
	}

}
