package com.bs.servlet;


import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Plan;
import com.bs.beans.Project;
import com.bs.beans.Record;
import com.bs.dao.impl.FunctionHand;
import com.bs.dao.impl.PlanHand;
import com.bs.dao.impl.ProjectHand;
import com.bs.dao.impl.RecordHand;
import com.bs.dao.impl.UserHand;
import com.bs.util.FormtoObject;

public class TurnProject extends HttpServlet {
	private FormtoObject f2o = new FormtoObject();
	private ProjectHand ph = new ProjectHand();
	private UserHand uh = new UserHand();
	private PlanHand plh = new PlanHand();
	private RecordHand rh = new RecordHand(); 
	private FunctionHand fh = new FunctionHand();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String pid = (String)request.getAttribute("pid");
			Project project = ph.query(Integer.parseInt(pid));
			//算出项目剩余时间
			String process=""; 
			if(project.getDeadline()!=null){
				long time1 = (new Date().getTime())-(project.getCreateTime().getTime());
				long time2 = (project.getDeadline().getTime())-(project.getCreateTime().getTime());
				NumberFormat format = NumberFormat.getPercentInstance();
				process = format.format(time1*1.0/time2);
			}else{
				process = "0%";
			}
			request.setAttribute("process", process);
			
			ArrayList<Plan> plans = plh.list(Integer.parseInt(pid));
			HashMap<Plan, String> map1 = new HashMap<Plan, String>();
			HashMap<Plan, String> map2 = new HashMap<Plan, String>();
			for (Plan plan : plans) {
				map1.put(plan, fh.search1(plan.getPlid()));
				map2.put(plan, fh.search2(plan.getPlid()));
			}
			request.setAttribute("map1", map1);
			request.setAttribute("map2", map2);
			
			ArrayList<Record> records = rh.list(Integer.parseInt(pid));
			ArrayList<Object> infos = new ArrayList<Object>();
			infos.add(project);
			infos.add(plans);
			infos.add(records);
			request.setAttribute("infos", infos);
			request.getRequestDispatcher("/page/myProject2.jsp").forward(request, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
