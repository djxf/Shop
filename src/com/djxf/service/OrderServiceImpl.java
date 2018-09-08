package com.djxf.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.djxf.Bean.Order;
import com.djxf.Bean.Product;
import com.djxf.Interface.CartDao;
import com.djxf.Interface.OrderDao;
import com.djxf.Interface.OrderService;
import com.djxf.Interface.ProductService;

public class OrderServiceImpl implements OrderService {
	CartDao cartDao = new CartDaoImpl();
	ProductService ps = new ProductImpl();
	OrderDao od = new OrderDaoImpl();
	@Override
	public Boolean submitOrder(String username) {
		
		// 1加载用户购物车数据
		HashMap<String, Integer> cartDataMap = cartDao.loadUserCartData(username);
		
		
		// 2计算订单金额
		double amount = 0;
		//分为：得到订单商品，数量，单价
		Set<Entry<String, Integer>> entrySet = cartDataMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			Product p = ps.getProduct(entry.getKey());
			p.setNum(entry.getValue());
			amount += p.getpPrice()*p.getNum();
		}
		// 3获取用户收货地址
		
		// 4生成订单id
		UUID uuid = UUID.randomUUID();
		String orderId = username+"_"+uuid;
		
		// 5生成订单时间
		Date date = new Date();
		
		//生成订单对象
		Order order = new Order(orderId,username,"地址暂无",amount,date);
		//模拟提交订单，存储订单HashMap<String,Order>
		HashMap<String,Order> orderMap = od.loadUserOrderData(username);
		orderMap.put(orderId, order);
		od.savaOrderData(username, orderMap);
		return true;
	}

	@Override
	public List<Order> checkOrder(String username) {
		HashMap<String, Order> userOrderDataMap = od.loadUserOrderData(username);
		ArrayList<Order> arrayList = new ArrayList<Order>(userOrderDataMap.values());
		return arrayList;
	}
}
