package com.yuansheng.www.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.yuansheng.www.dao.UserDao;
import com.yuansheng.www.domain.Users;
import com.yuansheng.www.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(Users users) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getConn();
		try {
			pstmt = conn.prepareStatement("insert into users(username,password,birthday)values(?,?,?)");
			pstmt.setString(1, users.getUsername());
			pstmt.setString(2, users.getPassword());
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
			String format = sft.format(users.getBirthday());
			pstmt.setString(3, format);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(conn, pstmt, null);
		}
	}
}
