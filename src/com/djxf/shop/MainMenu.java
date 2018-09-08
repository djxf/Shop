package com.djxf.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.djxf.Bean.Order;
import com.djxf.Bean.Product;
import com.djxf.Interface.CartService;
import com.djxf.Interface.OrderService;
import com.djxf.Interface.ProductDao;
import com.djxf.Interface.ProductService;
import com.djxf.Interface.UserService;
import com.djxf.service.CartServiceImpl;
import com.djxf.service.OrderDaoImpl;
import com.djxf.service.OrderServiceImpl;
import com.djxf.service.ProductDaoImplement;
import com.djxf.service.ProductImpl;
import com.djxf.service.UserServiceImpl;

public class MainMenu {

	public static void main(String[] args) {
		//引入用户服务层
		UserService us = new UserServiceImpl();
		System.out.println("清选择功能：1，注册 2，登录 3，管理员登录");
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		switch(select) {
		case "1":
			//注册
			System.out.println("请输入用户名:");
			String username = sc.nextLine();
			System.out.println("请输入密码:");
			String password1 = sc.nextLine();
			System.out.println("请再次输入密码确认:");
			String password2 = sc.nextLine();
			if(password1.equals(password2)) {
				//判断用户名是否存在
				boolean isExists =us.isExists(username);
				if(!isExists) {
					//注册
					us.register(username,password1);
					System.out.println("注册成功！");
					main(args);
				}else {
					System.out.println("用户名已存在，请重新输入用户名！");
					main(args);
				}
			}else {
				System.out.println("两次输入的密码不一样，请重新输入：");
				main(args);
			}
			break;
		case "2":
			//登录
			System.out.println("请输入用户名:");
			String username_login = sc.nextLine();
			System.out.println("请输入密码:");
			String password_login = sc.nextLine();
			//调用service层判断密码是否争取
			boolean secces = us.login(username_login,password_login);
			if(secces) {
				//登录成功
				System.out.println("登录成功！");
				//展示购物菜单
				showBuyMenu(username_login);
			}else {
				//登录失败
				System.out.println("用户名或密码错误！");
				main(args);
			}
			break;
		case "3":
			//管理员登录
			AdminMenu.showMainMenu();
			break;
		}
	}

	private static void showBuyMenu(String username) {
		 CartService cartservice = new CartServiceImpl();
		 ProductService ps = new ProductImpl();
		 OrderService os = new OrderServiceImpl();
		 System.out.println("请选择购物车:1 浏览商品 2 添加商品到购物车 3 查看购物车 4 修改购物车 5 提交订单 6 查看订单");
		 Scanner sc = new Scanner(System.in);
		 String select = sc.nextLine();
		 switch(select) {
		 case "1":
			 //浏览商品
			 List<Product> allProduct = ps.getAllProduct();
			 for(Product p:allProduct) {
				 if(p.isOnsale()) {
					 System.out.println(p);
				 }
			 }
			 showBuyMenu(username);
			 break;
		 case "2":
			 //添加商品到购物车
			 System.out.println("请输入商品信息格式：商品id,商品数量");
			 Scanner s = new Scanner(System.in);
			 String input = sc.nextLine();
			 String[] split = input.split(",");
			 if(split.length!=2) {
				 System.out.println("输入有误！请重新输入");
				 showBuyMenu(username);
			 }
			 try {
				 cartservice.addToCart(split[0],Integer.parseInt(split[1]),username); 
			 }catch(Exception e) {
				 e.printStackTrace();
				 System.out.println("未知原因添加失败！");
			 }
			 System.out.println("添加成功！");
			 showBuyMenu(username);
			 break;
		 case "3":
			 //查看购物车
			 ArrayList<Product> product = (ArrayList<Product>) cartservice.getUserCart(username);
			 for (Product p : product) {
				 System.out.println(p);
			 }
			 showBuyMenu(username);
			 break;
		 case "4":
			 //修改购物车
			 System.out.println("请选择功能：1 修改购物车 2 删除购物车");
			 Scanner scanner = new Scanner(System.in);
			 String select2 = scanner.nextLine();
			 if(select2.equals("1")) {
				 System.out.println("请输入修改的商品id及数量格式：id,数量");
				 select2 = scanner.nextLine();
				 String[] split2 = select2.split(",");
				 cartservice.updataCart(username,split2[0],Integer.parseInt(split2[1]));
				 System.out.println("修改成功！");
				 showBuyMenu(username);
			 }else if(select2.equals("2")) {
				 //删除购物车
				 System.out.println("请输入需要删除商品的id：");
				 String pid = scanner.nextLine();
				 cartservice.delectcart(username,pid);
				 showBuyMenu(username);
			 }else {
				 //输入错误
				 System.out.println("输入错误！");
				 showBuyMenu(username);
			 }
			 break;
		 case "5":
			 //提交订单
			 Boolean isSubmit = os.submitOrder(username);
			 if(isSubmit) {
				 System.out.println("提交成功！");
			 }else {
				 System.out.println("提交失败！");
			 }
			 showBuyMenu(username);
			 break;
		 case "6":
			 //查看订单
			 List<Order> orderlist = os.checkOrder(username);
			 for (Order order : orderlist) {
				System.out.println(order);
			}
			 showBuyMenu(username);
			 break;
			 default:
				 showBuyMenu(username);
				 break;
		 }
	}
}
