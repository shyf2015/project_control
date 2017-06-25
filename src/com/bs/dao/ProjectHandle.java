package com.bs.dao;

import java.util.ArrayList;

import com.bs.beans.Project;

public interface ProjectHandle {
	void add(Project project);
	void delete(int pid);
	void updata(Project project);
	ArrayList<Project> list();
	ArrayList<Project> list(int uid);
	Project query(int pid);
	ArrayList<Project> search(String str,int uid);
}
