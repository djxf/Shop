package com.djxf.service;

import java.util.HashMap;
import com.djxf.Bean.User;
import com.djxf.Interface.UserDao;
import com.djxf.Interface.UserService;

public class UserServiceImpl implements UserService{
	//注意子类实现
	UserDao userdao = new UserDaoImpl();
	@Override
	public boolean isExists(String username) {
		//需要调用Dao层获取到用户的hashmap
		HashMap<String,User> hashmap = userdao.laodUserData();
		return hashmap.containsKey(username);
	}

	@Override
	public void register(String username, String password1) {
		User user = new User(username,password1);
		
		//需要调用Dao层获取到用户的hashmap
		HashMap<String,User> hashmap = userdao.laodUserData();
		hashmap.put(username, user);
		//调用Dao层添加用户后保存数据
		userdao.savaUserData(hashmap);
	}
	/**
	 * 登录验证
	 */
	@Override
	public boolean login(String username_login, String password_login) {
		//需要调用Dao层获取到用户的hashmap
		HashMap<String,User> hashmap = userdao.laodUserData();
		if(hashmap.containsKey(username_login)) {
			return hashmap.get(username_login).getPassword().equals(password_login);
		}else {
			return false;			
		}
	}
}
