package com.djxf.Bean;

/**
 * 订单类
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable{

	public Order(String id, String username, String addr, double amout, Date data) {
		this.id = id;
		this.username = username;
		this.addr = addr;
		this.amout = amout;
		this.data = data;
	}
	private String id;
	private String username;
	private String addr;
	private double amout;
	private Date data;
	public String getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getAddr() {
		return addr;
	}
	public double getAmout() {
		return amout;
	}
	public Date getData() {
		return data;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setAmout(double amout) {
		this.amout = amout;
	}
	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Order [id=" + id + ", username=" + username + ", addr=" + addr + ", amout=" + amout + ", data=" + sdf.format(data)
				+ "]";
	}
}
