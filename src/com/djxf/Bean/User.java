package com.djxf.Bean;

import java.io.Serializable;
/**
 * 用户实体类
 * @author djxf
 *
 */
public class User implements Serializable {
	
	private String username;
	private String password;
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
