package com.school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.school.model.StudentModel;

public class StudentDAO {
	
	public Connection getConnection()throws Exception {

	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");

	 return con;

	 }
	
	
	 public String insert(StudentModel s) {
		 
		 int i=0;
		 try {

		  PreparedStatement ps=getConnection().prepareStatement("insert into student values(?,?,?,?,?)");

		  ps.setInt(1, s.getRollno());
		  ps.setString(2, s.getsName());
		  ps.setString(3, s.getStd());
		  ps.setString(4, s.getDob());
		  ps.setDouble(5, s.getFees());

		  i = ps.executeUpdate();
		 } 
		 
		 catch (Exception e) {
			 System.out.println(e);
		 }
		 
		 if(i>0){
		  return "Successfully inserted data";
		 }

		 else {
		  return "fail";
		 }
		 
	 }
	 
	 public String display(StudentModel s) {
		 
		 boolean flag = false;
		 try {

		  PreparedStatement ps=getConnection().prepareStatement("select * from student where rollno=?");
		  
		  ps.setInt(1,s.getRollno());
		  ResultSet rs = ps.executeQuery();
			
			 while(rs.next()) {
				 s.setRollno(rs.getInt("rollno"));
				 s.setsName(rs.getString("studentname")); 
				 s.setStd(rs.getString("standard"));
				 s.setDob( rs.getString("date_of_birth"));
				 s.setFee(rs.getDouble("fees"));
				 
				 System.out.format("%2s %15s %15s %15s %15s\n",s.getRollno(),s.getsName(),s.getStd(),s.getDob(),s.getFees());
				 flag = true;
			 }
		 }
		 
		 catch (Exception e) {
			 System.out.println(e);
		 }
			 if(flag) {
				 return "Records displayed based on particular rollno. ";
			 }
			 
			 return "Not able to display";
	 }
	 
	 public String displayAll(StudentModel s) {
		 
		 boolean flag = false;
		 try {

			 PreparedStatement ps = getConnection().prepareStatement("select * from student");  
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 s.setRollno(rs.getInt("rollno"));
				 s.setsName(rs.getString("studentname")); 
				 s.setStd(rs.getString("standard"));
				 s.setDob( rs.getString("date_of_birth"));
				 s.setFee(rs.getDouble("fees"));
				 
				 System.out.format("%2s %15s %15s %15s %15s\n",s.getRollno(),s.getsName(),s.getStd(),s.getDob(),s.getFees());
				 flag = true;
			 }
		 }
		 
		 catch (Exception e) {
			 System.out.println(e);
		 }
			 
			 if(flag) {
				 return "All Records displayed";
			 }
			 
			 return "Not able to display all records";
	 }
}
