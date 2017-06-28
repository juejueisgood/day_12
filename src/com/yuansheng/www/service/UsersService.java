package com.yuansheng.www.service;

import com.yuansheng.www.domain.Users;

public interface UsersService {
	/**
	 * 添加用户信息
	 * @param users
	 * @throws Exception
	 */
	public void add(Users users)throws Exception;
}
