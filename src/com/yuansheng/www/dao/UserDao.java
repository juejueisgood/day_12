package com.yuansheng.www.dao;

import com.yuansheng.www.domain.Users;

public interface UserDao {
	/**
	 * 添加用户信息
	 * @param users
	 * @throws Exception
	 */
	public void add(Users users)throws Exception;
}
