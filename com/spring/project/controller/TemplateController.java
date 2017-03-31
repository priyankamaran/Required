package com.spring.project.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.BeanDao.AdminBean;
import com.spring.project.BeanDao.AdminDAO;
import com.spring.project.BeanDao.TemplatesBean;
import com.spring.project.BeanDao.TemplatesDAO;

/*import daobean.AdminBean;
import daobean.AdminDAO;
import daobean.TemplatesDAO;*/



@RestController
@RequestMapping(value = "/templates")

public class TemplateController {


	
	 
	  @RequestMapping(value = "/templates" , method = RequestMethod.GET )
	  public List<TemplatesBean> getAllTemplates() {
		  TemplatesDAO td = new TemplatesDAO();
		ArrayList<TemplatesBean> list = td.getTemplateDetailsAdmin();  
	return list;
      }	

	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE )
	  public int removeRecord(@PathVariable("id") int id) {
		  TemplatesDAO td = new TemplatesDAO();
		int n = td.remove(id);  
	return n;
    }
	
	/*@RequestMapping(value="/templates",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces={ MediaType.APPLICATION_JSON_VALUE})
    public AdminBean addRecord(@RequestBody AdminBean tb)
	{
		
		AdminDAO ad = new AdminDAO();
		boolean check  =ad.fillDetails(tb);
		
		return tb;
	}*/
	 /*@RequestMapping(value = "/update/{id}/{name}" , method = RequestMethod.DELETE )
	  public int uRecord(@PathVariable("id") int id,@PathVariable("name") String s) {
		  TemplatesDAO td = new TemplatesDAO();
		int n = td.vote(s, id) ;
	return n;
   }
	*/
	@RequestMapping(value = "creditUpdates/{bookId}" , method = RequestMethod.PUT)

    public  int updatepurchasebook(@PathVariable("bookId")int tempId){

             /*List<TemplatesBean> list = new ArrayList<TemplatesBean>(); */

             AdminDAO tdao=new AdminDAO();

           int flag= tdao.updateCredits(tempId);

           

           return flag;

           

	}
	@RequestMapping(value = "/fillDetails",method = RequestMethod.PUT)

    public int insertDetails1(@RequestBody AdminBean template) {
System.out.println("I am in Url");
           AdminDAO bdao=new AdminDAO();

           int r= bdao.fillDetails(template);

           return r;

         

     }


    
}