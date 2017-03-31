package com.spring.project.BeanDao;
import java.io.*;
import java.util.*;
public class TemplatesBean {

	private String tempname;
	private String url;
	private int tempid,pvotes,nvotes;
	private float price;
	
/*	public TemplatesBean(int tempid,String tempname,int pvotes,int nvotes,String url)
	{
		this.tempname = tempname;
		this.tempid = tempid;
		this.pvotes=pvotes;
		this.nvotes=nvotes;
		this.url=url;
	}
*/
	

	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTempid() {
		return tempid;
	}

	public void setTempid(int tempid) {
		this.tempid = tempid;
	}
	public String getTempname() {
		return tempname;
	}

	public void setTempname(String tempname) {
		this.tempname = tempname;
	}
	public int getPvotes() {
		return pvotes;
	}

	public void setPvotes(int pvotes) {
		this.pvotes = pvotes;
	}

	public int getNvotes() {
		return nvotes;
	}

	public void setNvotes(int nvotes) {
		this.nvotes = nvotes;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
