package com.bs.servlet;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.beans.Function;
import com.bs.beans.Plan;
import com.bs.dao.impl.FunctionHand;
import com.bs.dao.impl.PlanHand;
import com.bs.util.FormtoObject;

public class FunctionServlet extends BaseServlet {
	private FunctionHand fh = new FunctionHand();
	private PlanHand ph = new PlanHand();
	private FormtoObject f2o = new FormtoObject();
	public String add(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			
			request.setCharacterEncoding("utf-8");
			String plid = request.getParameter("plid");
			Function function = (Function)f2o.form2Object(request, Function.class);
			fh.add(function);
			ArrayList<Function> functions = fh.list(Integer.parseInt(plid));
			Plan plan = ph.query(Integer.parseInt(plid));
			request.setAttribute("functions", functions);
			request.setAttribute("plan", plan);
			result = redirect+"/page/function.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String delete(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String plid = request.getParameter("plid");
			String fid = request.getParameter("fid");
			fh.delete(Integer.parseInt(fid));
			ArrayList<Function> functions = fh.list(Integer.parseInt(plid));
			Plan plan = ph.query(Integer.parseInt(plid));
			request.setAttribute("functions", functions);
			request.setAttribute("plan", plan);
			result = redirect+"/page/function.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String updata(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String plid = request.getParameter("plid");
			String fid = request.getParameter("fid");
			Function function = (Function)f2o.form2Object(request, Function.class);
			fh.updata(function);
			ArrayList<Function> functions = fh.list(Integer.parseInt(plid));
			Plan plan = ph.query(Integer.parseInt(plid));
			Function function2 = fh.query(Integer.parseInt(fid),Integer.parseInt(plid));
			request.setAttribute("function", function2);
			request.setAttribute("functions", functions);
			request.setAttribute("plan", plan);
			result = redirect+"/page/function.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String list(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String plid = request.getParameter("plid");
			ArrayList<Function> functions = fh.list(Integer.parseInt(plid));
			Plan plan = ph.query(Integer.parseInt(plid));
			request.setAttribute("functions", functions);
			request.setAttribute("plan", plan);
			result = redirect+"/page/function.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String query(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String plid = request.getParameter("plid");
			String fid = request.getParameter("fid");
			ArrayList<Function> functions = fh.list(Integer.parseInt(plid));
			Plan plan = ph.query(Integer.parseInt(plid));
			Function function = fh.query(Integer.parseInt(fid),Integer.parseInt(plid));
			request.setAttribute("function", function);
			request.setAttribute("functions", functions);
			request.setAttribute("plan", plan);
			result = redirect+"/page/function.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
