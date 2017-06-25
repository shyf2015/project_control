package com.bs.servlet;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Plan;
import com.bs.beans.Project;
import com.bs.beans.Record;
import com.bs.dao.impl.PlanHand;
import com.bs.dao.impl.ProjectHand;
import com.bs.dao.impl.RecordHand;
import com.bs.dao.impl.UserHand;
import com.bs.util.FormtoObject;

public class PlanServlet extends BaseServlet {
	private FormtoObject f2o = new FormtoObject();
	private PlanHand plh = new PlanHand();
	private RecordHand rh = new RecordHand(); 
	private ProjectHand ph = new ProjectHand();
	public String add(HttpServletRequest request,HttpServletResponse reponse){
		try {
			request.setCharacterEncoding("utf-8");
			String pid = request.getParameter("pid");
			String plname = request.getParameter("plname");
			if(plname!=null){
				Plan plan = (Plan)f2o.form2Object(request, Plan.class);
				plh.add(plan);
			}
			
			request.setAttribute("pid", pid);
			return redirect+"TurnProject";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String delete(HttpServletRequest request,HttpServletResponse reponse){
		try {
			request.setCharacterEncoding("utf-8");
			String pid = request.getParameter("pid");
			String plid = request.getParameter("plid");
			plh.delete(Integer.parseInt(plid));
			
			request.setAttribute("pid", pid);
			return redirect+"TurnProject";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
