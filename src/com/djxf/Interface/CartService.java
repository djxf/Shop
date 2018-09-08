package com.djxf.Interface;

import java.util.List;

import com.djxf.Bean.Product;

public interface CartService {
	/**
	 * 添加商品 到购物车
	 * @param string
	 * @param parseInt
	 */
	void addToCart(String string, int parseInt,String username);
	/**
	 * 查看购物车
	 * @param username
	 * @return
	 */
	List<Product> getUserCart(String username);
	
	/**
	 * 修改购物车数量
	 * @param username
	 * @return
	 */
	void updataCart(String username, String string, int parseInt);
	
	/**
	 * 根据商品id删除商品购物车
	 * @param username
	 * @param pid
	 */
	void delectcart(String username, String pid);

}
