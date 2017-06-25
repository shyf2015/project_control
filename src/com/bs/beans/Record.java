package com.bs.beans;

import java.util.Date;

public class Record {
	private int pid;
	private int rid;
	private Date time;
	private String content;
	private String title;
	public Record(int pid, int rid, Date time, String content, String title) {
		super();
		this.pid = pid;
		this.rid = rid;
		this.time = time;
		this.content = content;
		this.title = title;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Record [pid=" + pid + ", rid=" + rid + ", time=" + time
				+ ", content=" + content + ", title=" + title + "]";
	}
	
	
}
