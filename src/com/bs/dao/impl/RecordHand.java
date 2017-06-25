package com.bs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.bs.beans.Plan;
import com.bs.beans.Record;
import com.bs.dao.RecordHandle;
import com.bs.util.CreateConnection;

public class RecordHand implements RecordHandle{
	
	private CreateConnection con = new CreateConnection();
	public void add(Record record) {
		try {
			Connection connection = con.getConnection();
			String sql = "insert into t_record (pid,time,title,content) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, record.getPid());
			statement.setDate(2, new java.sql.Date(new Date().getTime()));
			statement.setString(3, record.getTitle());
			statement.setString(4, record.getContent());
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void delete(int rid) {
		// TODO Auto-generated method stub
		
	}

	public void updata(Record record) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Record> list(int pid) {
		ArrayList<Record> records = new ArrayList<Record>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_record where pid="+pid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int rid = set.getInt("rid");
				java.sql.Date time = set.getDate("time");
				String title = set.getString("title");
				String content = set.getString("content");
				Record record = new Record(pid, rid, time, content, title);
				records.add(record);
			}
			con.close(connection);
			return records;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
