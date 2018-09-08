package com.djxf.Interface;

import java.util.HashMap;
import com.djxf.Bean.User;

public interface UserDao {
	/**
	 * 加载用户数据
	 * @return
	 */
	HashMap<String, User> laodUserData();
	/**
	 * 保存用户数据
	 * @param hashmap
	 */
	void savaUserData(HashMap<String, User> hashmap);

}
