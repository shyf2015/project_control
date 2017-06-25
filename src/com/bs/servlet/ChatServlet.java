package com.bs.servlet;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Chat;
import com.bs.dao.impl.ChatHand;
import com.bs.util.FormtoObject;

public class ChatServlet extends BaseServlet{
	private FormtoObject f2o = new FormtoObject();
	private ChatHand ch = new ChatHand();
	public String add(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String user = request.getParameter("send");
			String recive = request.getParameter("recive");
			Chat chat1 = new Chat();
			chat1.setSend(user);
			chat1.setRecive(recive);
			Chat chat = (Chat)f2o.form2Object(request, Chat.class);
			ch.add(chat);
			ArrayList<Chat> chats = ch.list(chat1);
			
			request.setAttribute("user", user);
			request.setAttribute("recive", recive);
			request.setAttribute("chats", chats);
			result = redirect+"/page/chat.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String allList(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String user = request.getParameter("send");
			String recive = request.getParameter("recive");
			Chat chat1 = new Chat();
			chat1.setSend(user);
			chat1.setRecive(recive);
			ArrayList<Chat> chats = ch.allList(chat1);
			
			request.setAttribute("user", user);
			request.setAttribute("recive", recive);
			request.setAttribute("chats", chats);
			result = redirect+"/page/chat.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public String list(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String user = request.getParameter("send");
			String recive = request.getParameter("recive");
			Chat chat1 = new Chat();
			chat1.setSend(user);
			chat1.setRecive(recive);
			ArrayList<Chat> chats = ch.list(chat1);
			
			request.setAttribute("user", user);
			request.setAttribute("recive", recive);
			request.setAttribute("chats", chats);
			result = redirect+"/page/chat.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
