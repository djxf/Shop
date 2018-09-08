package com.djxf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.djxf.Bean.Product;
import com.djxf.Interface.ProductDao;
import com.djxf.Interface.ProductService;

public class ProductImpl implements ProductService{
	ProductDao product1 = new ProductDaoImplement();
	@Override
	public List<String> getAllCategory() {
		ArrayList<String> category = new ArrayList<String>();
		category.add("水果");
		category.add("蔬菜");
		category.add("肉类");
		return category;
	}

	@Override
	public List<Product> getAllProduct() {
		
		//调用Dao层 返回所有商品的hashMap
		HashMap<String,Product> hashMap = product1.loadProduct();
		
		//将所有商品放入一个List
		Collection<Product> plist = hashMap.values();
		ArrayList<Product> list = new ArrayList<Product>(plist);
		return list;
	}
	/**
	 * 根据类目查询
	 */
	@Override
	public ArrayList<Product> getProductByCategory() {
		//调用Dao层 返回所有商品的hashMap
		HashMap<String,Product> hashMap = product1.loadProduct();
		ArrayList<Product> lists = new ArrayList<Product>(hashMap.values());
		return lists ;
	}
	/**
	 * 根据id查商品
	 */
	@Override
	public Product getProduct(String id) {
		//调用Dao层 返回所有商品的hashMap
		HashMap<String,Product> hashMap = product1.loadProduct();
		Product product = hashMap.get(id);
		return product;
	}

	@Override
	public void addItem(String str) {
		//解析交互层输入的商品信息 pId:使用当前时间戳
		String[] pInfos = str.split(",");
		if(pInfos.length!=4) {
			System.out.println("输入商品格式错误！");
		}else {
		Product p = new Product(String.valueOf(System.currentTimeMillis()),pInfos[0],Float.parseFloat(pInfos[1]),pInfos[2],Integer.parseInt(pInfos[3]));
		//加载商品数据文件，作为一个HaseMap对象
		HashMap<String,Product> product =(HashMap<String,Product>) product1.loadProduct();
		//将本次的商品对象，加入商品数据文件
		product.put(p.getpId(),p);
		//重新存储商品数据文件
		product1.saveProductData(product);
		}
	}
	/**
	 * 根据id下架商品
	 */
	@Override
	public void outSale(String id) {
		//调用Dao层 返回所有商品的hashMap
		HashMap<String,Product> hashMap = product1.loadProduct();
		Product product = hashMap.get(id);
		product.setOnsale(false);
		product1.saveProductData(hashMap);
	}

	/**
	 * 根据id上架商品
	 */
	@Override
	public boolean sale(String id) {
		//调用Dao层 返回所有商品的hashMap
		HashMap<String,Product> hashMap = product1.loadProduct();
		Product product = hashMap.get(id);
		if(product.isOnsale()) {
			return true;
		}
		product.setOnsale(true);
		product1.saveProductData(hashMap);
		return false;
	}
}
