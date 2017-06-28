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

	// ע��
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//����������,��תʱ�ַ�����ת��
		response.setContentType("text/html;charset=UTF-8");
		// ��ȡ������
		Users users = new Users();
		try {
			
			// ��ȡ������
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(users, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		try {
			// ����ҵ���߼�
			UsersService us = new UsersServiceImpl();
			us.add(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �ַ�ת��
		response.getWriter().write("ע��ɹ�,1���Ӻ���ת��ҳ��");
		//������ת
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
