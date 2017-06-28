package com.yuansheng.www.domain;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable{
	private int id;
	private String username;
	private String password;
	//导入util下,而sql包下为util.Date的子类
	private Date birthday;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Users(){}
	public Users(int id, String username, String password, Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	
}
