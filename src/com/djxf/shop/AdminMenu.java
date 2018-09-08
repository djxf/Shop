package com.djxf.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.djxf.Bean.Product;
import com.djxf.Interface.ProductDao;
import com.djxf.Interface.ProductService;
import com.djxf.service.ProductDaoImplement;
import com.djxf.service.ProductImpl;

public class AdminMenu {
	/**
	 * 显示一级菜单
	 */
	public static void showMainMenu() {
		 
		 System.out.println("1:添加商品 2:浏览商品 3:上架商品 4:下架商品");
		 Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();
		 switch(str) {
		 case "1":
			 //添加商品
			 addItem(sc);
			 break;
		 case "2":
			 showProduct(sc);
			 break;
		 case "3":
			 //上架功能
			 Sale(sc);
			 break;
		 case "4":
			 //下架商品
			 unSale(sc);
			 break;
		 default:
				 System.out.println("输入有误 请重新输入");
				 showMainMenu();
		 }
	}
	/**
	 * 根据id上架商品
	 * @param sc
	 */
	private static void Sale(Scanner sc) {
		//接口的子类
		ProductService service = new ProductImpl();
		System.out.println("请输入上架商品的id");
		String id = sc.nextLine();
		boolean state = service.sale(id);
		if(state) {
			System.out.println("该商品已经在上架中！");
		}else {
			System.out.println("上架成功");
		}
	}
	private static void unSale(Scanner sc) {
		//接口的子类
		ProductService service = new ProductImpl();
		System.out.println("请输入需要下架商品的id");
		String id = sc.nextLine();
		service.outSale(id);
		System.out.println("下架成功");
	}
	/**
	 * 添加商品
	 */
	public static void addItem(Scanner scanner) {
		//接口的子类
		ProductService service = new ProductImpl();
		//展示商品
		List<String> category = service.getAllCategory();
		System.out.println(category);
		
		//提示管理员输入信息，并提示格式
		System.out.println("请输入商品信息，格式：商品名称，商品价格，商品类目，商品库存数量");
		
		//获取管理员的输入商品信息
		String pInfo = scanner.nextLine();
		
		//调用service层添加商品的方法
		service.addItem(pInfo);
		
		//回显一级菜单
		showMainMenu();
	}
	
	/**
	 * 浏览商品
	 */
	public static void showProduct(Scanner sc) {
		ProductService service = new ProductImpl();
		System.out.println("请选择功能：1 查询全部商品,2 按照id查询 3 按照商品类目查询");
		String str = sc.nextLine();
		switch(str) {
		case "1":
			//查询全部商品
			List<Product> list = service.getAllProduct();
			for (Product product : list) {
				System.out.println(product);
			}
			break;
		case "2":
			//按照id查询
			System.out.println("请输入商品id：");
			String id = sc.nextLine();
			Product product = service.getProduct(id);
			System.out.println(product);
			break;
		case "3":
			//按照商品类目查询
			System.out.println("请输入商品类目: ");
			String category = sc.nextLine();
			ArrayList<Product> lists_category = (ArrayList<Product>) service.getProductByCategory();
			for(Product p:lists_category) {
				//字符串的比较不能用==
				if(category.equals(p.getCategory())) {
					System.out.println(p);
				}
			}
			break;
			default:
				System.out.println("请输入正确的功能1-3");
				showProduct(sc);
		}
	}
	
	
	/**
	 * 上架商品
	 */
	
	
	
	/**
	 * 下架商品
	 */
}
