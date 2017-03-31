package com.spring.project;

import java.util.List;

import com.spring.project.BeanDao.TemplatesBean;

public interface ITestDao {
	
	public List<TemplatesBean> getAllTests() throws Exception;
	/*public Test getTestDetails(String testId) throws Exception;
	public Test createTest(Test testObj) throws Exception;
	public Test updateTest(Test testObj) throws Exception;
	public Test deleteTest(String testId) throws Exception;
	*/


}
