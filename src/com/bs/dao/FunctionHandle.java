package com.bs.dao;

import java.util.ArrayList;

import com.bs.beans.Function;

public interface FunctionHandle {
	public void add(Function function);
	public void delete(int fid);
	public void updata(Function function);
	public ArrayList<Function> list(int plid);
	public Function query(int fid,int plid);
}
