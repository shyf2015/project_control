package com.bs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.bs.beans.Project;
import com.bs.beans.User;
import com.bs.dao.ProjectHandle;
import com.bs.util.CreateConnection;

public class ProjectHand implements ProjectHandle{
	private CreateConnection con = new CreateConnection();
	public void add(Project project) {
		try {
			Connection connection = con.getConnection();
			String sql = "insert into t_project (pname,manager,description,createtime,uid) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, project.getPname());
			statement.setString(2, project.getManager());
			statement.setString(3, project.getDescription());
			statement.setDate(4, new java.sql.Date(new Date().getTime()));
			statement.setInt(5, project.getUid());
			statement.execute();
			con.close(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void delete(int pid) {
		try {
			Connection connection = con.getConnection();
			Statement statement = connection.createStatement();
			String sql = "delete from t_project where pid="+pid;
			statement.execute(sql);
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updata(Project project) {
		try {
			Connection connection = con.getConnection();
			String sql = "update t_project set pname=?,manager=?,description=?,deadline=?,parter=? where pid="+project.getPid();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, project.getPname());
			statement.setString(2, project.getManager());
			statement.setString(3, project.getDescription());
			statement.setDate(4, new java.sql.Date(project.getDeadline().getTime()));
			statement.setString(5, project.getParter());
			statement.execute();
			con.close(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public ArrayList<Project> list() {
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_project";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int pid = set.getInt("pid");
				String pname = set.getString("pname");
				String manager = set.getString("manager");
				String description = set.getString("description");
				String parter = set.getString("parter");
				String cost = set.getString("cost");
				Date createTime = set.getDate("createtime");
				Date deadline = set.getDate("deadline");
				int uid = set.getInt("uid");
				Project project = new Project(pid, uid, pname, manager, createTime, description, deadline, parter, cost);
				projects.add(project);
			}
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return projects;
	}
	public ArrayList<Project> list(int uid) {
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_project where uid="+uid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int pid = set.getInt("pid");
				String pname = set.getString("pname");
				String manager = set.getString("manager");
				String description = set.getString("description");
				String parter = set.getString("parter");
				String cost = set.getString("cost");
				Date createTime = set.getDate("createtime");
				Date deadline = set.getDate("deadline");
				Project project = new Project(pid, uid, pname, manager, createTime, description, deadline, parter, cost);
				projects.add(project);
			}
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return projects;
	}
	

	public Project query(int pid) {
		ArrayList<Project> projects = list();
		for (Project project : projects) {
			if(project.getPid()==pid){
				return project;
			}
		}
		return null;
	}

	public ArrayList<Project> search(String str,int uid) {
		ArrayList<Project> projects = list(uid);
		ArrayList<Project> projects2 = new ArrayList<Project>();
		for (Project project : projects) {
			if(project.getPname().contains(str) || project.getManager().contains(str)){
				projects2.add(project);
			}
		}
		return projects2;
	}
	
}
