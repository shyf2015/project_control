package com.bs.dao;

import java.util.ArrayList;

import com.bs.beans.Record;

public interface RecordHandle {
	void add(Record record);
	void delete(int rid);
	void updata(Record record);
	ArrayList<Record> list(int pid);
}
