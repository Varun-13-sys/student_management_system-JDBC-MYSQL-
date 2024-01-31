package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMainProject {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		intro();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Varun@2002#");
		
 while (true) {
	            intro();

	            // Get user choice
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Select ur Choice: ");
	    int choice = scanner.nextInt();
switch(choice) {
		case 1:insert();
		System.out.println("***************************");
		System.out.println("^^^^^^^Inset Record^^^^^^^^");
		System.out.println("***************************");
				break;
		case 2:edit();
		System.out.println("***************************");
		System.out.println("^^^^^^^^Edit Record^^^^^^^^");
		System.out.println("***************************");
				break;
		case 3:view();
		System.out.println("***************************");
		System.out.println("^^^^^^^^View record^^^^^^^^");
		System.out.println("***************************");
				break;
		case 4:delete();
		System.out.println("***************************");
		System.out.println("^^^^^^^Delete Record^^^^^^^");
		System.out.println("***************************");
				break;
		case 5:System.exit(0);
				break;
		default:System.out.println("******invalid choice******");
				break;	
		}
 	}
 }
	public static void delete() throws SQLException {
		Scanner s=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Varun@2002#");
		System.out.println("enter row no to delete");
		int m=s.nextInt();
		String query="delete from student_info where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, m);
		ps.executeUpdate();
		System.out.println("data deleted successfully");
	}
	public static void view() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Varun@2002#");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student_info");
		System.out.println("ID | Name | std  | fname ");
		System.out.println("----------------------------");
		while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
	}
	public static void edit() throws ClassNotFoundException, SQLException {
		String url3="jdbc:mysql://localhost:3306/sms_db";
		Connection con3=DriverManager.getConnection(url3,"root","Varun@2002#");
		view();
		String query="UPDATE student_info SET Name=?,std=?,fname=? WHERE(id=?);";
		PreparedStatement ps=con3.prepareStatement(query);
		Scanner s=new Scanner(System.in);
		System.out.println("enter id to edit");
		int i=s.nextInt();
		System.out.println("enter  the name");
		s.nextLine();
		String n=s.nextLine();
		System.out.println("enter the class");
		String c=s.nextLine();
		System.out.println("enter the father name");
		String f=s.nextLine();
		ps.setString(1, n);
		ps.setString(2,c);
		ps.setString(3,f);
		ps.setInt(4,i);
		ps.executeUpdate();
		System.out.println("data updated successfully");
	}
    public static void insert() throws SQLException {
	Scanner s=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url,"root","Varun@2002#");
	System.out.println("enter  the name");
	String n=s.nextLine();
	System.out.println("enter the class");
	String c=s.nextLine();
	System.out.println("enter the father name");
	String f=s.nextLine();
	System.out.println("enter the mobile number");
	String m=s.nextLine();
	String query="insert into student_info (Name,std,fname,mobile) value(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1, n);
	ps.setString(2, c);
	ps.setString(3, f);
	ps.setString(4, m);
	ps.executeUpdate();
	System.out.println("data inserted successfully");
	
}
    public  static void intro() {
	System.out.println("******");
	System.out.println("STUDENT MODULE");
	System.out.println("******");
	System.out.println("\n1.Insert");
	System.out.println("2.Edit");
	System.out.println("3.View");
	System.out.println("4.Delete");
	System.out.println("5.Exit");
}
}