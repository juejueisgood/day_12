package com.yuansheng.www.dao;

import com.yuansheng.www.domain.Users;

public interface UserDao {
	/**
	 * ����û���Ϣ
	 * @param users
	 * @throws Exception
	 */
	public void add(Users users)throws Exception;
}
