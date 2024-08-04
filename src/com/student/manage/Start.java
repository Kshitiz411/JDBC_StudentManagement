package com.student.manage;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Start {
	
	public static void main(String[] args)  throws IOException{
		System.out.println("Welcome to Student Management APP");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	while(true) {
		System.out.println("Press 1 to Add student");
		System.out.println("press 2 to Delete Student");
		System.out.println("press 3 to Display student");
		System.out.println("press 4 to Update Student");
		System.out.println("press 5 to exit app");
		
		int c=Integer.parseInt(br.readLine());
		if(c==1)
		{
			//add student
			System.out.println("Enter user name :");
			String name = br.readLine();
			
			System.out.println("Enter user phone :");
			String phone = br.readLine();
			
			System.out.println("Enter user city");
			String city = br.readLine();

			//create student object store student
			Student st = new Student(name, phone,city);
			 boolean answer = StudentDao.insertStudentToDB(st);
			 if(answer) {
				 System.out.println("student is added successfully...");
			 }else 
			 {
				 System.out.println("Something went wrong try again...");
			 }
			System.out.println(st);
			
			
		}else if(c==2) 
		{
			//delete student
			System.out.println("Enter student id to delete:");
			int userId = Integer.parseInt(br.readLine());
			boolean f =StudentDao.deleteStudent(userId);
			
			if(f) {
				System.out.println("Deleted successfully...");
			}else {
				System.out.println("Something went wrong.. ");
				
			}
			
		}else if(c==3) 
		{
			//display student
			
			StudentDao.showAllStudents();
		}else if(c==4){
			//update
			System.out.println("Enter student id to updated..");
			int st=Integer.parseInt(br.readLine());
			 
			System.out.println("Enter user name to updated :");
			String name = br.readLine();
			
			System.out.println("Enter user phone to updated :");
			String phone = br.readLine();
			
			System.out.println("Enter user city to be updated");
			String city = br.readLine();
			
			Student st1 =new Student(name,phone, city);

			boolean answer1 = StudentDao.updateStudentToDB(st1);
			
			 if(answer1) {
				 System.out.println("student is updated successfully...");
			 }else 
			 {
				 System.out.println("Something went wrong try again...");
			 }
			System.out.println(st);
			
		}else if(c==5)
			
		{
			break;
		}else 
		{
		 
	}
	}
	System.out.println("Thankyou for using my application...");
	System.out.println("See you soon..bye bye!!");

}
}
