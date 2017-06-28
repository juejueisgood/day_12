package com.yuansheng.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.yuansheng.www.domain.Users;
import com.yuansheng.www.service.UsersService;
import com.yuansheng.www.service.impl.UsersServiceImpl;

public class regeditServlet extends HttpServlet {

	// 注册
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置请求行,跳转时字符进行转译
		response.setContentType("text/html;charset=UTF-8");
		// 获取表单数据
		Users users = new Users();
		try {
			
			// 获取表单数据
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(users, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		try {
			// 处理业务逻辑
			UsersService us = new UsersServiceImpl();
			us.add(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 分发转向
		response.getWriter().write("注册成功,1秒钟后跳转主页面");
		//进行跳转
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
