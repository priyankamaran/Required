package com.spring.project.BeanDao;

public class PurchaseBean {
	//private int purchase_id;
	private int cust_id;
	//private String purchase_date;
	private int credits_spent;
	private int credits_earned;
	private float total_price;
	/*public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}*/
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	/*public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}*/
	public int getCredits_spent() {
		return credits_spent;
	}
	public void setCredits_spent(int credits_spent) {
		this.credits_spent = credits_spent;
	}
	public int getCredits_earned() {
		return credits_earned;
	}
	public void setCredits_earned(int credits_earned) {
		this.credits_earned = credits_earned;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	

}
