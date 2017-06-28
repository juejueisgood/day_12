package com.yuansheng.www.utils;

import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class DBUtils {
	private static String url;
	private static String driver;
	private static String username;
	private static String password;
	static {
		init();
	}

	public static void init() {
		ResourceBundle rb = ResourceBundle.getBundle("database");
		driver = rb.getString("dirver");
		username = rb.getString("name");
		password = rb.getString("pwd");
		url = rb.getString("url");
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void closeAll(Connection conn, PreparedStatement pstmt,
			ResultSet rset) throws SQLException {
		if (rset != null) {
			rset.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}

}
