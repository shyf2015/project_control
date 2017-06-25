package com.bs.beans;

import java.util.Date;

public class Chat {
	private String send;
	private String recive;
	private Date time;
	private String content;
	public Chat(String send, String recive, Date time, String content) {
		super();
		this.send = send;
		this.recive = recive;
		this.time = time;
		this.content = content;
	}
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getRecive() {
		return recive;
	}
	public void setRecive(String recive) {
		this.recive = recive;
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
	@Override
	public String toString() {
		return "Chat [send=" + send + ", recive=" + recive + ", time=" + time
				+ ", content=" + content + "]";
	}
	
	
}
