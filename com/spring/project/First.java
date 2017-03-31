package com.spring.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First extends HttpServlet{
	private ServletConfig config;
	public void init(ServletConfig config)
	{
		this.config=config;
		System.out.println("Servlet is initialized");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<b>hello simple servlet</b>");
		out.print("</body></html>");
		
	}

}
