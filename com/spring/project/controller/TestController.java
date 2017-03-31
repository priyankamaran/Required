package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.TestDaoImpl;
/*import com.spring.project.Data;
import com.nxn.tra.api.model.ErrorDetails;
import com.nxn.tra.api.model.MetaData;
import com.nxn.tra.api.model.Response;
import com.nxn.tra.api.model.Test;*/
import com.spring.project.BeanDao.TemplatesBean;


@RestController
public class TestController {
	
	
	@Autowired
	TestDaoImpl testDaoimpl;
	
	
	@RequestMapping(value="/tests", method=RequestMethod.GET)
		
	public List<TemplatesBean> getAllTestDetails() throws Exception
	{
		
		List<TemplatesBean> testList;
		
			testList = testDaoimpl.getAllTests();
System.out.println("last");
			/*saveMetaData(true,"Tests loaded","12345");*/
			/*saveData(null, testList);
			saveResponse(data,metaData, null);
		*/
			// TODO Auto-generated catch block
			/*errorDetails.setCode("00005");
			errorDetails.setDescription(e.getMessage());;
			saveMetaData(false,"Error Occured","12345");
			
			saveResponse(null,metaData,errorDetails);*/
			//return response;

for(TemplatesBean b:testList)
{
	System.out.println(b.toString());
}
		return testList;
	}
	

	
	/*private void saveResponse(Data data, MetaData metaData, ErrorDetails errorDet) {
		response.setData(data);
		response.setMetaData(metaData);
		response.setError(errorDet);
	}
	private void saveData(ErrorDetails erroDet, List testObj) {
		response.setError(erroDet);
			data.setOutput(testObj);
		
	}
	
	
	
	private void saveMetaData(boolean success, String description, String responseId){
		
		
		metaData.setSuccess(success);
		metaData.setDescription(description);
		metaData.setResponseId(responseId);
	}*/
	

}
