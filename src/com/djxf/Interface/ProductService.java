package com.djxf.Interface;

import java.util.List;

import com.djxf.Bean.Product;
import java.util.ArrayList;

public interface ProductService {
	/**
	 * 获取所有商品类目信息
	 * @return
	 */
		public List<String> getAllCategory();
		
	/**
	 * 添加商品
	 */
		public void addItem(String str);
	/**
	 * 查询全部商品
	 * @return
	 */
	public List<Product> getAllProduct();
	/**
	 * 根据id查询单个商品
	 * @param id
	 * @return
	 */
	public Product getProduct(String id);
	/**
	 * 根据类目查询
	 * @param category
	 * @return
	 */
	public List<Product> getProductByCategory();
	/**
	 * 根据id下架商品
	 * @param id
	 */
	public void outSale(String id);

	/**
	 * 根据id上架架商品
	 * @param id
	 */
	public boolean sale(String id);
}
