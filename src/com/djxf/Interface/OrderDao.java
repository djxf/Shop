package com.djxf.Interface;

import java.util.HashMap;

import com.djxf.Bean.Order;

public interface OrderDao {
	/**
	 * 加载用户订单数据
	 * @param username
	 * @return
	 */
	HashMap<String, Order> loadUserOrderData(String username);
	/**
	 * 保存用户订单数据
	 * @param orderMap
	 */
	void savaOrderData(String username,HashMap<String, Order> orderMap);

}
