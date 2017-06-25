package com.bs.beans;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String password;
	private String phone;
	private String email;
	private int sex;
	private String school;
	private Date birthday;
	private String company;
	private String head;
	public User(int uid, String uname, String password, String phone,
			String email, int sex, String school, Date birthday,
			String company, String head) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.sex = sex;
		this.school = school;
		this.birthday = birthday;
		this.company = company;
		this.head = head;
	}
	public User(String uname, String password, String phone,
			String email) {
		super();
		this.uname = uname;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password="
				+ password + ", phone=" + phone + ", email=" + email + ", sex="
				+ sex + ", school=" + school + ", birthday=" + birthday
				+ ", company=" + company + ", head=" + head + "]";
	}
	
	
	
}
