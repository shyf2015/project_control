package com.bs.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.beans.Function;
import com.bs.dao.FunctionHandle;
import com.bs.util.CreateConnection;

public class FunctionHand implements FunctionHandle{
	
	
	private CreateConnection con = new CreateConnection();
	private PrintWriter writer;
	private BufferedReader reader;
	
	public void add(Function function) {
		try {
			//创建存放代码的文件
			File file = new File("code/"+function.getFname()+".txt");
			file.createNewFile();
			//创建输出流
			//writer = new PrintWriter("code/"+function.getFname()+".txt", "utf-8");
			//向文件写入代码数据
			//writer.println(function.getCode());
			//writer.close();
			
			Connection connection = con.getConnection();
			String sql = "insert into t_function (plid,fname,code) values(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, function.getPlid());
			statement.setString(2, function.getFname());
			statement.setString(3, "code/"+function.getFname()+".txt");
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int fid) {
		try {
			Connection connection = con.getConnection();
			String sql = "delete from t_function where fid="+fid;
			Statement statement = connection.createStatement();
			statement.execute(sql);
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updata(Function function) {
		try {
			//创建输出流
//			System.out.println(function);
			writer = new PrintWriter("code/"+function.getFname()+".txt", "utf-8");
			//向文件写入代码数据
			writer.println(function.getCode());
			writer.close();
			
			Connection connection = con.getConnection();
			String sql = "update t_function set fdescription=?,state=? where fid="+function.getFid();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, function.getFdescription());
			statement.setInt(2, function.getState());
			statement.execute();
			con.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Function> list(int plid) {
		ArrayList<Function> functions = new ArrayList<Function>();
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_function where plid="+plid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int fid = set.getInt("fid");
				String fname = set.getString("fname");
				String fdescription = set.getString("fdescription");
				int state = set.getInt("state");
				String codefile = set.getString("code");
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(codefile),"utf-8"));
				String code = "";
				String str = null;
				while((str=reader.readLine())!=null){
					code += str;
				}
				reader.close();
				Function function = new Function(plid, fid, fname, fdescription, code, state);
				functions.add(function);
			}
			con.close(connection);
			return functions;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Function query(int fid,int plid) {
		ArrayList<Function> functions = list(plid);
		for (Function function : functions) {
			if(function.getFid()==fid){
				return function;
			}
		}
		return null;
	}
	//查询未完成的功能
	public String search1(int plid){
		String result="";
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_function where state!=3 and plid="+plid;
			Statement statement  = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				String fname = set.getString("fname");
				result += " "+fname;
			}
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	//查询已完成的功能
	public String search2(int plid){
		String result="";
		try {
			Connection connection = con.getConnection();
			String sql = "select * from t_function where state=3 and plid="+plid;
			Statement statement  = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				String fname = set.getString("fname");
				result += " "+fname;
			}
			con.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
