package com.bs.servlet;


import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Plan;
import com.bs.beans.Project;
import com.bs.beans.Record;
import com.bs.dao.impl.PlanHand;
import com.bs.dao.impl.ProjectHand;
import com.bs.dao.impl.RecordHand;
import com.bs.util.FormtoObject;

public class RecordServlet extends BaseServlet {
	private FormtoObject f2o = new FormtoObject();
	private PlanHand plh = new PlanHand();
	private RecordHand rh = new RecordHand(); 
	private ProjectHand ph = new ProjectHand();
	public String add(HttpServletRequest request,HttpServletResponse reponse){
		try {
			request.setCharacterEncoding("utf-8");
			String pid = request.getParameter("pid");
			String title=request.getParameter("title");
			String content = request.getParameter("content");
			if(title!=null&&content!=null){
				Record record = (Record)f2o.form2Object(request, Record.class);
				rh.add(record);
			}
			
			request.setAttribute("pid", pid);
			return redirect+"TurnProject";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
