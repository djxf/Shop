package com.djxf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.djxf.Bean.Product;
import com.djxf.Interface.ProductDao;

public class ProductDaoImplement implements ProductDao{
	/**
	 * 把商品数据文件加载出一个hashMap
	 * 预设文件位置：D://shop//Product//product.data
	 */
	@Override
	public HashMap<String, Product> loadProduct() {
		/**
		 * 特别处理，第一次添加时文件不存在所有应用创建一个空的
		 */
		File file= new File("D:"+File.separator+"shop.obj");
		if(!file.exists()) {
			HashMap<String, Product> hasemap = new HashMap<String, Product>();
			saveProductData(hasemap);
			return hasemap;
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:"+File.separator+"shop.obj"));
			HashMap<String, Product> hashmap = (HashMap<String, Product>) ois.readObject();
			ois.close();
			return hashmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 保存商品信息
	 */
	@Override
	public void saveProductData(HashMap<String, Product> hashmap) {
		try {
			//类需要使用可序列化接口
			FileOutputStream fos = new FileOutputStream("D:"+File.separator+"shop.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hashmap);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
