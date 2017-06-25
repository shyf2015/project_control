package com.bs.dao;

import java.util.ArrayList;

import com.bs.beans.Plan;

public interface PlanHandle {
	void add(Plan plan);
	void delete(int plid);
	void updata(Plan plan);
	ArrayList<Plan> list(int pid);
	Plan query(int plid);
}
