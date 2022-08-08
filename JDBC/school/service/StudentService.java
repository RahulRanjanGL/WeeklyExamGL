package com.school.service;

import java.util.ArrayList;
import java.util.List;

import com.school.dao.StudentDAO;
import com.school.model.StudentModel;

public class StudentService {
	
	public String insert(StudentModel student)
	 {
		
		         String roll;
		         boolean checkroll = false;
				 roll = String.valueOf(student.getRollno());
			     
				  if(roll.length()==4) {
					  checkroll = true;
					  student.setRollno(Integer.parseInt(roll));
				  }
				  else {
					  System.out.println("Not a 4 digit RollNo.");
				  	}
				  	  
				      boolean checkName = false;
					  String name = student.getsName().toUpperCase();
					  
					  if(student.getsName().equals(name) && student.getsName().length()<=20) {
						  checkName = true;
					  }
					  else {
						  System.out.println("Please enter the name in upper case or length of name should be less than 20!!");
						  System.out.println();
					  }
				 
				  boolean checkStd = false;
				  List<String> list = new ArrayList<String>();
				  
				  list.add("I");
				  list.add("II");
				  list.add("III");
				  list.add("IV");
				  list.add("V");
				  list.add("VI");
				  list.add("VII");
				  list.add("VIII");
				  list.add("IX");
				  list.add("X");
				  
						if(list.contains(student.getStd())) {
							checkStd = true;
						}
						else {
							System.out.println("Standard Not exists in the List...Try Again!!");
							System.out.println();
						}
	   
		if(checkroll == true && checkName == true && checkStd == true) {	 
			StudentDAO sdao=new StudentDAO();
		 	return sdao.insert(student);
		}
		
		return "Insertion rule is violating, Try Again !!";
	 }
	
	public String display(StudentModel student)
	 {
		StudentDAO sdao=new StudentDAO();
	 	return sdao.display(student);
	 }
	
	public String displayAll(StudentModel student) {
		
		StudentDAO sdao=new StudentDAO();
	 	return sdao.displayAll(student);
	}
}
