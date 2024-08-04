package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	private static int id;

	public static boolean insertStudentToDB(Student st) {
		boolean f=false;
		
		
		try {
			//jdbc code..
			Connection con = CP.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			//  to fire we use preapatredStatement
		 PreparedStatement pstmt=con.prepareStatement(q);
			// set the values of parameter
		pstmt.setString(1,st.getStudentName());
		pstmt.setString(2,st.getStudentPhone());
		pstmt.setString(3,st.getStudentCity());
		
			//exucte..
		pstmt.executeUpdate();
		con.close(); 
		f=true;	
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean deleteStudent(int userId) {
boolean f=false;
		
		
		try {
			//jdbc code..
			Connection con = CP.createC();
			String q = "delete from students where sid=? ";
			
			//  to fire we use preapatredStatement
		 PreparedStatement pstmt=con.prepareStatement(q);
			// set the values of parameter
		pstmt.setInt(1, userId);
		
			//exucte..
		pstmt.executeUpdate();
		con.close(); 
		f=true;	
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
		
		
	}

	public static void showAllStudents() {
		
boolean f=false;
		
		
		try {
			//jdbc code..
			Connection con = CP.createC();
			String q = "select * from students";
			
			//  to fire we use Statement
		Statement stmt = con.createStatement();
			//exucte..
		ResultSet set=stmt.executeQuery(q);
		
		while(set.next()) {
			int id= set.getInt(1);
			String name = set.getString(2);
			String phone = set.getString(3);
			String city = set.getString("scity");
			
			
			System.out.println("ID : " + id);
			System.out.println("Name : " + name);
		    System.out.println("Phone : " + phone);
		    System.out.println("City : " + city);
		    System.out.println("-----------------");
		  
		  	
			
			
		}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	public static boolean updateStudentToDB(Student st1) {
		// TODO Auto-generated method stub
boolean f=false;
		
		
		try {
			//jdbc code..
			Connection con = CP.createC();
			String q = "update students set sname=? ,sphone=?, scity=? where sid=?";
			
			//  to fire we use preapatredStatement
		 PreparedStatement pstmt=con.prepareStatement(q);
			// set the values of parameter
		pstmt.setString(1,st1.getStudentName());
		pstmt.setString(2,st1.getStudentPhone());
		pstmt.setString(3,st1.getStudentCity());
		
		pstmt.setInt(4,st1.getStudentId());
		
			//exucte..
		pstmt.executeUpdate();
		con.close(); 
		f=true;	
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	}




