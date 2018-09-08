package com.djxf.Interface;

public interface UserService {
	/**
	 * 判断用户名是否存在
	 * @author Administrator
	 *
	 */
	boolean isExists(String username);
	
	/**
	 * 注册
	 * @param username
	 * @param password1
	 */
	void register(String username, String password1);
	/**
	 * 登录
	 * @param username_login
	 * @param password_login
	 * @return
	 */
	boolean login(String username_login, String password_login);

 
}
