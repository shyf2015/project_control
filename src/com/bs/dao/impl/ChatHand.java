package com.bs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.bs.beans.Chat;
import com.bs.dao.ChatHandle;
import com.bs.util.CreateConnection;

public class ChatHand implements ChatHandle{
	private CreateConnection con = new CreateConnection();
	public void add(Chat chat) {
		try {
			Connection connection = con.getConnection();
			String sql = "insert into t_chat values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,chat.getSend());
			statement.setString(2,chat.getRecive());
			statement.setDate(3, new java.sql.Date((new Date().getTime())));
			statement.setString(4,chat.getContent());
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Chat> list(Chat chat) {
		ArrayList<Chat> chats = allList(chat);
		if(chats.size()<16){
			return chats;
		}
		ArrayList<Chat> chats2 = new ArrayList<Chat>();
		for(int i=(chats.size()-16);i<chats.size();i++){
			chats2.add(chats.get(i));
		}
		return chats2;
	}

	public ArrayList<Chat> allList(Chat chat) {
		ArrayList<Chat> chats = new ArrayList<Chat>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_chat where (send=? and recive=?) or (send=? and recive=?)"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, chat.getSend());
			statement.setString(2, chat.getRecive());
			statement.setString(3, chat.getRecive());
			statement.setString(4, chat.getSend());
			ResultSet set = statement.executeQuery();
			while(set.next()){
				String send = set.getString("send");
				String recive = set.getString("recive");
				Date time = set.getDate("time");
				String content = set.getString("content");
				Chat chat2 = new Chat(send, recive, time, content);
				chats.add(chat2);
			}
			con.close(connection);
			return chats;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
