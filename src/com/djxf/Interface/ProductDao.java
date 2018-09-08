package com.djxf.Interface;

import java.util.HashMap;

import com.djxf.Bean.Product;

public interface  ProductDao {
	/**
	 * 加载HaseMap<pid,Product>
	 * @return 
	 */
	public HashMap<String,Product> loadProduct();
	
	/**
	 * 存入haseMap；
	 */
	public void saveProductData(HashMap<String,Product> hashmap);
}
