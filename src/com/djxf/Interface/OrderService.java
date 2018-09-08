package com.djxf.Interface;

import java.util.List;

import com.djxf.Bean.Order;

/**
 * 订单管理功能
 * @author Administrator
 *
 */
public interface OrderService {
	/**
	 * 提交订单
	 * @param username
	 * @return
	 */
	Boolean submitOrder(String username);
	/**
	 * 查看订单
	 * @param username
	 * @return
	 */
	List<Order> checkOrder(String username);

}
