package com.spring.project.servlet;
import java.lang.*;

import static java.lang.System.*;

import java.io.*;
import java.util.*;

/*import com.spring.project.*;*/
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.spring.project.BeanDao.AdminBean;
import com.spring.project.BeanDao.AdminDAO;

public class RecordUserDetails extends HttpServlet
{
	final static Logger logger = Logger.getLogger(RecordUserDetails.class);
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RecordUserDetails() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	//{
		
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
	int flag=0;
		AdminBean aBean = new AdminBean();
		AdminDAO adao = new AdminDAO();
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        aBean.setName(request.getParameter("name"));
        String mail=request.getParameter("mail");
       /* if(mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))*/
        aBean.setMail_id(mail);
       /* else
        {
        	++flag;
        	out.println("Invalid Email-id");
        	//response.sendRedirect("/ServletDemo/Register.html");
        	RequestDispatcher rd=request.getRequestDispatcher("/Register.html");  
            rd.include(request, response);  
         
        }*/
        String text=request.getParameter("mnum");
       /* if (text.matches("[0-9]+") && text.length()==10)
        {
        	*/
        	aBean.setContact(text);
       // }
       /* else if(flag==0)
        {
        	out.println("Invalid Mobile Number");
        	RequestDispatcher rd=request.getRequestDispatcher("/Register.html");  
            rd.include(request, response);  
            ++flag;
        	 
        }*/
        String pwd=request.getParameter("pwd");
        String cwd=request.getParameter("cwd");
       //System.out.println(pwd+" ")
       /* if(pwd.compareTo("")!=0&&pwd.compareTo(cwd)==0)
        {*/
        aBean.setPwd(pwd);
        
        int check = adao.fillDetails(aBean);
        if(check!=0)
        {
        	System.out.println("REGISTRATION SUCCESSFULL!");
        	response.sendRedirect("Login.html");
        }
        
       /* else if(flag==0)
        {
        	out.println("Invalid Password");
        	//response.sendRedirect("/Register.html");
        	RequestDispatcher rd=request.getRequestDispatcher("/Register.html");  
            rd.include(request, response);  
        	 
        }*/
        
		/*Enumeration paramNames = request.getParameterNames();
		out.print("<html><body>");
        out.print("<h1>Customer Details</h1>");
        out.println("<table>");
        out.println("<tr> <th>Parameter Name</th>" + "<th>Parameter Value</th></tr>"); 
        while(paramNames.hasMoreElements()) 
        {
            String paramName = (String)paramNames.nextElement();
            out.print("<tr><td>" + paramName + "\n<td>");
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) 
            {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    
                {
                	//out.println("No Value");
                	
                }
                else
                    
                {
                	//out.println(paramValue);
                	
                	
                }
            } 
            else
            {
                //out.println("<ul>");
                for(int i=0; i<paramValues.length; i++) 
                {
                    out.println("<li>" + paramValues[i] + "</li>");
                }
                //out.println("</ul>");
            }
        }
    out.println("</table></body></html>");*/
    }
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	
	}

		


