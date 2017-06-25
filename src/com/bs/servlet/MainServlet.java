package com.bs.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.beans.User;
import com.bs.dao.impl.UserHand;

public class MainServlet extends HttpServlet {
	private UserHand uh = new UserHand();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		int uid = (Integer)session.getAttribute("xiangmu");
		User user = uh.query(uid);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}
}
