package com.bs.servlet;

import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Plan;
import com.bs.beans.Project;
import com.bs.beans.Record;
import com.bs.beans.User;
import com.bs.dao.impl.FunctionHand;
import com.bs.dao.impl.PlanHand;
import com.bs.dao.impl.ProjectHand;
import com.bs.dao.impl.RecordHand;
import com.bs.dao.impl.UserHand;
import com.bs.util.FormtoObject;

public class ProjectServlet extends BaseServlet {
	private FormtoObject f2o = new FormtoObject();
	private ProjectHand ph = new ProjectHand();
	private UserHand uh = new UserHand();
	private PlanHand plh = new PlanHand();
	private RecordHand rh = new RecordHand(); 
	private FunctionHand fh = new FunctionHand();
	public String add(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String uname = request.getParameter("uname");
			User user = uh.query(uname);
			Project project = (Project)f2o.form2Object(request, Project.class);
			ph.add(project);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirect+"/main.jsp";
	}
	
	public String delete(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String pid = request.getParameter("pid");
			String uid = request.getParameter("uid");
			ph.delete(Integer.parseInt(pid));
			ArrayList<Project> projects = ph.list(Integer.parseInt(uid));
			request.setAttribute("projects", projects);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return redirect+"/page/myProject.jsp";
	}
	
	public String updata(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String pid = request.getParameter("pid");
			Project project3 = (Project)f2o.form2Object(request, Project.class);
			ph.updata(project3);
			request.setAttribute("pid", pid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirect+"TurnProject";
	}
	
	public String list(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String uid = request.getParameter("uid");
			ArrayList<Project> projects = ph.list(Integer.parseInt(uid));
			request.setAttribute("projects", projects);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return redirect+"/page/myProject.jsp";
	}
	
	public String query(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String pid = request.getParameter("pid");
			request.setAttribute("pid", pid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return redirect+"TurnProject";
	}
	
	public String search(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String uid = request.getParameter("uid");
			String str = request.getParameter("sousuo");
			ArrayList<Project> projects = ph.search(str,Integer.parseInt(uid));
			request.setAttribute("projects", projects);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return redirect+"/page/myProject.jsp";
	}
	
}
