package com.djxf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.djxf.Interface.CartDao;

public class CartDaoImpl implements CartDao {
	/**
	 * 将购物车数据保存到本地
	 */
	@Override
	public void savaToUserData(HashMap<String, Integer> hashMap,String username) {
		File file = new File("D:\\shop\\userData\\cart");
		//第一次文件存在特殊处理先创建一个文件夹 注意文件夹的创建
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\shop\\userData\\cart\\"+username+".data"));
			oos.writeObject(hashMap);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件路径未找到");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件io异常");
			e.printStackTrace();
		}
	}
	/**
	 * 加载用户购物车数据
	 */
	@Override
	public HashMap<String, Integer> loadUserCartData(String username) {
		//文件夹不存在就创建文件夹
		String path = username+".data";
		File file = new File("D:\\shop\\userData\\cart");
		File file2 = new File("D:\\shop\\userData\\cart\\"+path);
		if(!file.exists()) {
			file.mkdirs();
		}
		//文件不存在就创建文件
		if(!file2.exists()) {
			try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2));
			HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
			oos.writeObject(hashMap);
			oos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2));
			HashMap<String, Integer> cartHashMap  = (HashMap<String, Integer>) ois.readObject();
			return cartHashMap;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
