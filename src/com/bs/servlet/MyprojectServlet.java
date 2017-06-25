package com.bs.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Project;
import com.bs.dao.impl.ProjectHand;

public class MyprojectServlet extends HttpServlet {
	private ProjectHand ph = new ProjectHand();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uid = req.getParameter("uid");
		ArrayList<Project> projects = ph.list(Integer.parseInt(uid));
		req.setAttribute("projects", projects);
		req.getRequestDispatcher("/page/myProject.jsp").forward(req, resp);
	}
}
