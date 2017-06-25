package com.bs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.beans.Plan;
import com.bs.dao.PlanHandle;
import com.bs.util.CreateConnection;


public class PlanHand implements PlanHandle{
	private CreateConnection con = new CreateConnection();
	public void add(Plan plan) {
		try {
			Connection connection = con.getConnection();
			String sql = "insert into t_plan (pid,plname,hours,pdescription) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, plan.getPid());
			statement.setString(2, plan.getPlname());
			statement.setInt(3, plan.getHours());
			statement.setString(4, plan.getPdescription());
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void delete(int plid) {
		try {
			Connection connection = con.getConnection();
			String sql = "delete from t_plan where plid="+plid;
			Statement statement = connection.createStatement();
			statement.execute(sql);
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void updata(Plan plan) {
		try {
			Connection connection = con.getConnection();
			String sql = "updata t_plan set plname=?,hours=?,pdescription=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, plan.getPlname());
			statement.setInt(2,plan.getHours());
			statement.setString(3,plan.getPdescription());
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public ArrayList<Plan> list(int pid) {
		ArrayList<Plan> plans = new ArrayList<Plan>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_plan where pid="+pid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int plid = set.getInt("plid");
				int hours = set.getInt("hours");
				String plname = set.getString("plname");
				String pdescription = set.getString("pdescription");
				Plan plan = new Plan(pid, plid, plname, hours, pdescription);
				plans.add(plan);
			}
			con.close(connection);
			return plans;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Plan query(int plid) {
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_plan where plid="+plid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int pid = set.getInt("pid");
				String plname = set.getString("plname");
				int hours = set.getInt("hours");
				String pdescription = set.getString("pdescription");
				Plan plan = new Plan(pid, plid, plname, hours, pdescription);
				return plan;
			}
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
