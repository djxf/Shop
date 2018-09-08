package com.djxf.Interface;

import java.util.HashMap;

public interface CartDao {
	/**
	 * 
	 * 将购物车的数据保存到本地储存
	 * @param hashMap
	 * @param username 
	 */
	void savaToUserData(HashMap<String, Integer> hashMap, String username);
	
	/**
	 * 加载指定的用户的购物车数据文件，返回一个HashMap<String,Integer>
	 * @param username
	 * @return
	 */
	HashMap<String,Integer> loadUserCartData(String username);
	
}
