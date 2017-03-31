package com.spring.project;

import java.sql.Types;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.spring.project.ITestDao;
/*import com.nxn.tra.api.model.Test;*/
import com.spring.project.TestRowMapper;
import com.spring.project.BeanDao.TemplatesBean;

@Component
public class TestDaoImpl extends JdbcDaoSupport implements ITestDao {

	@Autowired
	public TestDaoImpl(DataSource datasource) {
		// TODO Auto-generated constructor stub
		setDataSource(datasource);
	}

	public List<TemplatesBean> getAllTests() throws Exception {
		// TODO Auto-generated method stub
		List<TemplatesBean> testList = null;

		testList = getJdbcTemplate().query("select * from T_XBBNHCJ_Templates",
				new Object[] {}, new TestRowMapper());
System.out.println("I am here");
System.out.println(testList);
Iterator itr =testList.iterator();
for(TemplatesBean b:testList)
{
	System.out.println(b.toString());
}
		return testList;
	}

	/*public Test getTestDetails(String testId)  {
		// TODO Auto-generated method stub
		Test testObj = null;

		getJdbcTemplate().quer
		
		testObj = getJdbcTemplate().queryForObject(
				"select * from T_XBBLPN7_TEST where test_Id = ?",
					new Object[] { testId }, new TestRowMapper());		

		return testObj;

	}

	public Test createTest(Test testObj) throws Exception {
		// TODO Auto-generated method stub
		int numRows = 0;
		Date date = new Date();

		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.DATE, Types.VARCHAR };
		Object param[] = { testObj.getTestId(), testObj.getTestName(),
				testObj.getTestDuration(), testObj.getTestInstr(), date,
				testObj.getTestChargeBack() };

		numRows = getJdbcTemplate().update(
				"insert into T_XBBLPN7_TEST values(?,?,?,?,?,?)", param, types);
		return( numRows == 1 ?  testObj: null);

	}

	public Test deleteTest(String testId) {
		// TODO Auto-generated method stub
		int numRows = 0;
		Test testObj = null;
		try {
			testObj = getJdbcTemplate().queryForObject(
					"select * from T_XBBLPN7_TEST where test_id = ? ",
					new Object[] { testId }, new TestRowMapper());
			numRows = getJdbcTemplate().update(
					"delete from T_XBBLPN7_TEST where test_id=?",
					new Object[] { testId }, new int[] { Types.VARCHAR });

		} catch (Throwable error) {
			System.out.println("Got error.  Returning null (404)");
			error.printStackTrace();
		}
		return(numRows == 1 ? testObj : null);
		

	}

	public Test updateTest(Test testObj) {
		// TODO Auto-generated method stub
		int numRows = 0;
		try {
			numRows = getJdbcTemplate()
					.update("update T_XBBLPN7_TEST set test_name=?, test_duration=? where test_id = ? ",
							new Object[] { testObj.getTestName(),
									testObj.getTestDuration(),
									testObj.getTestId() },
							new int[] { Types.VARCHAR, Types.VARCHAR,
									Types.VARCHAR });
		} catch (Throwable error) {
			System.out.println("Got error.  Returning null (404)");
			error.printStackTrace();
		} finally {
			if (numRows > 0)
				return testObj;
			else
				return null;

		}

	}*/

}
