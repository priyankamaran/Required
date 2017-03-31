package com.spring.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.spring.project.BeanDao.CustomizationBean;
import com.spring.project.BeanDao.CustomizationDAO;
import com.spring.project.BeanDao.TemplatesBean;
import com.spring.project.BeanDao.TemplatesDAO;



public class CustomizationServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(CustomizationServlet.class);
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		try{
		PrintWriter out  = response.getWriter();
				response.setContentType("text/html");
				HttpSession session = request.getSession();
				CustomizationDAO cdao = new CustomizationDAO();
				CustomizationBean cBean= new CustomizationBean();
				cBean.setContact(request.getParameter("contact"));
				cBean.setQuote(request.getParameter("quote"));
				cBean.setTitle(request.getParameter("title"));
				cBean.setTempname(request.getParameter("category"));
				cBean.setCustId((Integer)session.getAttribute("uid"));
				cBean.setTempId((Integer)session.getAttribute("tempid"));
			    int n = cdao.setCustomizationDetails(cBean);
			    TemplatesDAO td = new TemplatesDAO();
			   TemplatesBean tb = new TemplatesBean();
			   tb.setNvotes(Integer.parseInt(request.getParameter("nv")));
			   tb.setPvotes(Integer.parseInt(request.getParameter("pv")));
			   tb.setTempid((Integer)session.getAttribute("tempid"));
			   td.vote(tb);
			   //System.out.println(request.getParameter("category"));
			   session.setAttribute("forpurchase",request.getParameter("category"));
			   if(n==1)
				
				   {
				   //out.println("Customization Successful!");
				   request.setAttribute("contact",request.getParameter("contact"));
				   request.setAttribute("quote",request.getParameter("quote"));
				   request.setAttribute("title",request.getParameter("title"));
				   request.setAttribute("category",request.getParameter("category"));
				   
				   
				   session.setAttribute("contact",request.getParameter("contact"));
				   session.setAttribute("quote",request.getParameter("quote"));
				   session.setAttribute("title",request.getParameter("title"));
				   if(request.getParameter("category").compareTo("Flower1")==0)
				   {
					   RequestDispatcher rd=request.getRequestDispatcher("/Flower11.jsp");  
			            rd.include(request, response);  
				   }
				   else
				   {
					   RequestDispatcher rd=request.getRequestDispatcher("/FirstPurchase11.jsp");  
			            rd.include(request, response);  
				   }
				   
				   }	   }
		catch(Exception e)
		
		{
			logger.error(e.getMessage());
		}
			   
	}

}
