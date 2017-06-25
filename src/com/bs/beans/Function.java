package com.bs.beans;

public class Function {
	private int plid;
	private int fid;
	private String fname;
	private String fdescription;
	private String code;
	private int state;
	public Function(int plid, int fid, String fname, String fdescription,
			String code, int state) {
		super();
		this.plid = plid;
		this.fid = fid;
		this.fname = fname;
		this.fdescription = fdescription;
		this.code = code;
		this.state = state;
	}
	public Function(int plid, String fname, String fdescription,
			String code, int state) {
		super();
		this.plid = plid;
		this.fname = fname;
		this.fdescription = fdescription;
		this.code = code;
		this.state = state;
	}
	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPlid() {
		return plid;
	}
	public void setPlid(int plid) {
		this.plid = plid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Function [plid=" + plid + ", fid=" + fid + ", fname=" + fname
				+ ", fdescription=" + fdescription + ", code=" + code
				+ ", state=" + state + "]";
	}
	
	
}
