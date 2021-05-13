package com.djxf.Bean;

import java.io.Serializable;
/**
 * 商品实体类
 * @author djxf
 */
public class Product implements Serializable{

	private String pName;
	private String pId;
	private boolean isOnsale = true;
	private float pPrice;
	private String category;
	private int num;
	
	public Product(String pId,String pName, float pPrice, String category, int num) {
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.category = category;
		this.num = num;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getpPrice() {
		return pPrice;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public  boolean isOnsale() {
		return isOnsale;
	}

	public void setOnsale(boolean isOnsale) {
		this.isOnsale = isOnsale;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
	@Override
	public String toString() {
		return this.pId+","+this.pName+","+this.pPrice+","+this.category+","+this.num+"上架状态:"+(this.isOnsale == true?"已上架":"已下架");
	}
}
