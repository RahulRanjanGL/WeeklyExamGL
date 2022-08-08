package com.school.controller;

import java.util.Scanner;

import com.school.model.StudentModel;
import com.school.service.StudentService;
public class Main {

	public static void main(String[] args) {
		
		 Scanner sc=new Scanner(System.in);
		 
			 System.out.print("Enter the Roll No. : ");
			 int rollno = sc.nextInt();
			 
			 System.out.print("Enter the Name : ");
			 sc.nextLine();	
			 String sName = sc.nextLine();
			 
			 System.out.print("Enter Standard of the Student : ");
			 String	std = sc.nextLine();
			 
			 System.out.print("Enter Date of Birth : ");
			 String dob = sc.nextLine();
			 
			 System.out.print("Enter fees of the student : ");
			 double fees = sc.nextDouble();
			 
			 StudentModel student = new StudentModel(rollno, sName, std, dob, fees);
			 StudentService service = new StudentService();
			 
			 System.out.println("Press 1 to Insert");
			 System.out.println("Press 2 to Display based on a RollNo.");
			 System.out.println("Press 3 to Display all records");
			 System.out.println();
			 System.out.println("Enter your choice : ");
			 int ch = sc.nextInt();
			 
			 switch(ch) {
			
		 case 1:
			 System.out.println();
			 String res = service.insert(student);
			 System.out.println(res);
			 break;
			 
		 case 2:
			 System.out.println();
			 System.out.println("Enter the roll no. for which you want to display record : ");
			 rollno = sc.nextInt();
			 
			 String res1 = service.display(student);
			 System.out.println(res1);
			 break;
			 
		 case 3:
			 System.out.println();
			 String res2 = service.displayAll(student);
			 System.out.println(res2);
			 break;
			 
		default:
			System.out.println("Wrong Choice !!");
			break;
		 }
	}

}
