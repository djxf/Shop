package com.djxf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.djxf.Bean.User;
import com.djxf.Interface.UserDao;

public class UserDaoImpl implements UserDao {
	File file = new File("D:"+File.separator+"user.data");
	@Override
	public HashMap<String, User> laodUserData() {
		try {
		//第一次文件不存在时创建文件
		if (!file.exists()) {
			HashMap<String, User> hashmap = new HashMap<String,User>();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(hashmap);
			oos.flush();
			oos.close();
			return hashmap;
		}
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();
		return hashmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回空注意空指针
		return null;
	}
	/**
	 * 保存用户数据
	 * @param hashmap
	 */
	@Override
	public void savaUserData(HashMap<String, User> hashmap) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(hashmap);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
