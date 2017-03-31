package com.spring.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.spring.project.BeanDao.TemplatesBean;

public class TestRowMapper implements RowMapper<TemplatesBean> {

	public TemplatesBean mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		
		TemplatesBean testObj =new TemplatesBean();
		testObj.setTempid(rs.getInt(1));
		testObj.setTempname(rs.getString(2));
		
		testObj.setPvotes(rs.getInt(3));
		testObj.setNvotes(rs.getInt(4));
		testObj.setUrl(rs.getString(5));
		testObj.setPrice(rs.getFloat(6));
		
		/*testObj.setTestDuration(rs.getString(3));*/
		/*testObj.setTestCreatedTs(DateFormatter.getNexenFormatDate(rs.getTimestamp(5)));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" +rs.getTimestamp(5));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + DateFormatter.getNexenFormatDate(rs.getTimestamp(5)));
		testObj.setTestChargeBack(rs.getString(6));*/
		return testObj;
	}

}
