package com.yuansheng.www.service.impl;

import com.yuansheng.www.dao.UserDao;
import com.yuansheng.www.dao.impl.UserDaoImpl;
import com.yuansheng.www.domain.Users;
import com.yuansheng.www.service.UsersService;

public class UsersServiceImpl implements UsersService {
	UserDao userdao = new UserDaoImpl();
	@Override
	public void add(Users users) throws Exception {
		userdao.add(users);
	}
}
