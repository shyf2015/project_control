package com.bs.beans;

import java.util.Date;

public class Project {
	private int pid;
	private int uid;
	private String pname;
	private String manager;
	private Date createTime;
	private String description;
	private Date deadline;
	private String parter;
	private String cost;
	public Project(int pid, int uid, String pname, String manager,
			Date createTime, String description, Date deadline, String parter,
			String cost) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.pname = pname;
		this.manager = manager;
		this.createTime = createTime;
		this.description = description;
		this.deadline = deadline;
		this.parter = parter;
		this.cost = cost;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getParter() {
		return parter;
	}
	public void setParter(String parter) {
		this.parter = parter;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", uid=" + uid + ", pname=" + pname
				+ ", manager=" + manager + ", createTime=" + createTime
				+ ", description=" + description + ", deadline=" + deadline
				+ ", parter=" + parter + ", cost=" + cost + "]";
	}
	
	
}
