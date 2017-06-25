package com.bs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.bs.beans.User;
import com.bs.dao.UserHandle;
import com.bs.util.CreateConnection;

public class UserHand implements UserHandle{
	private CreateConnection con = new CreateConnection();
	public void add(User user) {
		try {
			Connection connection = con.getConnection();
			String sql = "insert into t_user (uname,password,phone,email) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUname());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getEmail());
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int uid) {
		// TODO Auto-generated method stub
		
	}

	public void updata(User user) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<User> list() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_user";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int uid = set.getInt("uid");
				String password = set.getString("password");
				String phone = set.getString("phone");
				String email = set.getString("email");
				int sex = set.getInt("sex");
				String school = set.getString("school");
				Date birthday = set.getDate("birthday");
				String company = set.getString("company");
				String head = set.getString("head");
				String uname = set.getString("uname");
				User user = new User(uid, uname, password, phone, email, sex, school, birthday, company, head);
				users.add(user);
			}
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
	public User query(String uname) {
		ArrayList<User> users = list();
		for (User user : users) {
			if(uname.equals(user.getUname())){
				return user;
			}
		}
		return null;
	}

	
	public User query(int uid) {
		ArrayList<User> users = list();
		System.out.println(users.size());
		for (User user : users) {
			if(user.getUid()==uid){
				return user;
			}
		}
		return null;
	}

	public Boolean isExsit(User user) {
		ArrayList<User> users = list();
		for (User user2 : users) {
			
			if(user.getUname().equals(user2.getUname())&&user.getPassword().equals(user2.getPassword())){
				return true;
			}
		}
		return false;
	}

	public boolean ishas(String username) {
		try {
			ArrayList<User> users = list();
			for (User user : users) {
				if(username.equals(user.getUname())){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
}
