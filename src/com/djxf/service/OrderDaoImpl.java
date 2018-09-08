package com.djxf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.djxf.Bean.Order;
import com.djxf.Interface.OrderDao;

public class OrderDaoImpl implements OrderDao{

	@Override
	public HashMap<String, Order> loadUserOrderData(String username) {
		File file = new File("D:\\shop\\userorder");
		if(!file.exists()) {
			file.mkdirs();
		}
		File file2 = new File("D:\\shop\\userorder"+username+"_orders.dat");
		try {
		if(!file2.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2));
			HashMap<String, Order> hashMap = new HashMap<String,Order>();
			oos.writeObject(hashMap);
			oos.close();
		}
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2));
		HashMap<String,Order> map= (HashMap<String, Order>) ois.readObject();
		ois.close();
		return map;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void savaOrderData(String username,HashMap<String, Order> orderMap) {
		File file2 = new File("D:\\shop\\userorder"+username+"_orders.dat");
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file2));
			oos.writeObject(orderMap);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		}
}
