package com.school.model;

public class StudentModel {
	
	private int rollno;
	private String sName;
	private String std;
	private String dob;
	private double fees;
	
	
	public StudentModel(int rollno, String sName, String std, String dob, double fees) {
		super();
		this.rollno = rollno;
		this.sName = sName;
		this.std = std;
		this.dob = dob;
		this.fees = fees;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getFees() {
		return fees;
	}
	public void setFee(double fees) {
		this.fees = fees;
	}
	
}
