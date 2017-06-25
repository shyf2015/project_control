package com.bs.servlet;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.beans.User;
import com.bs.dao.impl.UserHand;
import com.bs.util.FormtoObject;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class UserServlet extends BaseServlet {
	private FormtoObject f2o = new FormtoObject();
	private UserHand uh = new UserHand();
	public String add(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			User user = (User)f2o.form2Object(request, User.class);
			
			uh.add(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return redirect+"/page/login.jsp";
	}
	public String login(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			User user = (User)f2o.form2Object(request, User.class);
			if(true){
				User user2 = uh.query(user.getUname());
				request.setAttribute("user", user2);
				HttpSession session = request.getSession();
				session.setAttribute("xiangmu", user2.getUid());
				session.setAttribute("xiangmu2", user2.getUname());
				ServletContext application = this.getServletContext();
				ArrayList<String> online_users = (ArrayList<String>)application.getAttribute("online_users");
				if(online_users != null){
					online_users.add(user.getUname());
					application.setAttribute("online_users", online_users);
				}else{
					ArrayList<String> users = new ArrayList<String>();
					users.add(user.getUname());
					application.setAttribute("online_users", users);
				}
				result = redirect+"/main.jsp";
			}else{
				request.setAttribute("error", "not");
				result = redirect+"/page/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public String ishas(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			System.out.println();
			if(uh.ishas(username)){
				out.print("yes");
			}else{
				out.print("no");
			}
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return redirect;
	}
//	public String delete(){}
//	public String updata(){}
//	public String list(){}
}
