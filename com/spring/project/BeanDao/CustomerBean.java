package com.spring.project.BeanDao;

public class CustomerBean {
	private String custname,mailid;
	private int custid,credits;
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String i) {
		this.mailid = i;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	

}
