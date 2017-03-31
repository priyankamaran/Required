package com.spring.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;








import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.spring.project.BeanDao.AdminBean;
import com.spring.project.BeanDao.AdminDAO;



public class ValidateUser extends HttpServlet {
	/**
	 * 
	 */
	
	final static Logger logger = Logger.getLogger(ValidateUser.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
	try{
		AdminBean aBean = new AdminBean();
		AdminDAO adao = new AdminDAO();
		PrintWriter out = response.getWriter();
		
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        aBean.setName(request.getParameter("name"));
        session.setAttribute("uname",request.getParameter("name"));
        String pwd=request.getParameter("pwd");
        
        aBean.setPwd(pwd);
        
        
     int check = adao.authenticate(aBean);
        if(check!=0)
        {
        	//out.println("LOGIN SUCCESSFULL!");

    		/*logger.debug("This is debug");*/
    		
    		/*logger.warn("This is warn");
    		logger.error("This is error");
    		logger.fatal("This is fatal");*/
			session.setAttribute("uid",check);
        	/*RequestDispatcher rd=request.getRequestDispatcher("/weapp/Template.html");  
        	
        	 rd.include(request, response); */
			session.setAttribute("checkSession","continue");
			response.sendRedirect("Template.html");
        	 //System.out.println("hi"+check);
        	 session.setAttribute("download", false);
        	 System.out.println(session);
        	 //Cookie ck=new Cookie("name",request.getParameter("name")); 
             //ck.setMaxAge(30);
             //response.addCookie(ck);  
        	//response.sendRedirect("/ServletDemo/Template.html");
        	 
        }
        
        else
        {
        	out.println("Invalid user name and password");
        	System.out.println("hi");
        	/*RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
            rd.include(request, response);  */
        	response.sendRedirect("Login.html");
        }
        
    }
catch(Exception e)
	
	{
		logger.error(e.getMessage());
	}


	}
	
}
