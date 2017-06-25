package com.bs.beans;

public class Plan {
	private int pid;
	private int plid;
	private String plname;
	private int hours;
	private String pdescription;
	public Plan(int pid, int plid, String plname, int hours, String pdescription) {
		super();
		this.pid = pid;
		this.plid = plid;
		this.plname = plname;
		this.hours = hours;
		this.pdescription = pdescription;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPlid() {
		return plid;
	}
	public void setPlid(int plid) {
		this.plid = plid;
	}
	public String getPlname() {
		return plname;
	}
	public void setPlname(String plname) {
		this.plname = plname;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	@Override
	public String toString() {
		return "Plan [pid=" + pid + ", plid=" + plid + ", plname=" + plname
				+ ", hours=" + hours + ", pdescription=" + pdescription + "]";
	}
	
	
}
