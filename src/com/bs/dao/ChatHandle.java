package com.bs.dao;

import java.util.ArrayList;

import com.bs.beans.Chat;

public interface ChatHandle {
	void add(Chat chat);
	ArrayList<Chat> list(Chat chat);
	ArrayList<Chat> allList(Chat chat);
}
