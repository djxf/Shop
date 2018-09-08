package com.djxf.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.djxf.Bean.Product;
import com.djxf.Interface.CartDao;
import com.djxf.Interface.CartService;
import com.djxf.Interface.ProductService;

public class CartServiceImpl implements CartService{
	CartDao cartdao = new CartDaoImpl();
	ProductService productservice = new ProductImpl();
	@Override
	public void addToCart(String string, int parseInt,String username) {
		HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put(string, parseInt);
		cartdao.savaToUserData(hashMap,username);	
	}

	@Override
	public ArrayList<Product> getUserCart(String username) {
		//利用cartDao返回一个hashMap
		HashMap<String, Integer> userCart = cartdao.loadUserCartData(username);
		
		//利用productService获取商品的详细信息
		ArrayList<Product> arrayList = new ArrayList<Product>();
		Set<Entry<String, Integer>> entrySet = userCart.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			Product p = productservice.getProduct(entry.getKey());
			p.setNum(entry.getValue());
			arrayList.add(p);
		}
		//将数据转成一个list即可
		return arrayList;
	}
	
	@Override
	public void updataCart(String username, String string, int num) {
		//加载用户的购物车
		HashMap<String, Integer> cartMap = cartdao.loadUserCartData(username);
		//更新用户的购物车数量
		if(num==-1) {
			cartMap.remove(string);
		}else {
			cartMap.put(string, num);
		}
				
		//保存用户的购物车数量
		cartdao.savaToUserData(cartMap, username);
	}

	@Override
	public void delectcart(String username, String pid) {
		
				
	}
}
