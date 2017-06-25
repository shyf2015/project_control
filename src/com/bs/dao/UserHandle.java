package com.bs.dao;

import java.util.ArrayList;

import com.bs.beans.User;

public interface UserHandle {
	Boolean isExsit(User user);
	void add(User user);
	void delete(int uid);
	void updata(User user);
	ArrayList<User> list();
	User query(int uid);
	User query(String uname);
	boolean ishas(String username);
}
