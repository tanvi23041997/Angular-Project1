package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.bo.Student;
import com.dao.StudentDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	@Resource(name="oracledb")
	public static DataSource dataSource;
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//to inset the record into student info
		/*StudentDAO.dataSource= this.dataSource; 
		System.out.println("adding the details");


		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		
		Student stud=null;
		try {
			stud = new Student(3,"reena","reena123","c1","it",new java.sql.Date(sdf.parse("18-07-1996").getTime()),"sam","h");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=StudentDAO.addStudent(stud);
		if(i>0) 
		{
			System.out.println("added");
			//System.out.println(stud);
			response.getWriter().write(stud.getStudentId());
		}
		else
		{
			response.getWriter().println("-1");
		}*/
		
	
//to display the list of students
		/*System.out.println("request received");
		//to get all employee
		StudentDAO.dataSource=this.dataSource;
		List<Student> list=StudentDAO.getAllStud();
		
		if(list.size()!=0)
		{
			/*GsonBuilder gsonBuilder=new GsonBuilder();
			Gson gson=gsonBuilder.create();
			String jsonString=gson.toJson(list);
			response.getWriter().print(jsonString);*/
			//System.out.println(list);
		
		//}
		//to get the details of the student
    System.out.println("request received");
	//to get all employee
//    InputStreamReader reader=new InputStreamReader(request.getInputStream());
//    BufferedReader br=new BufferedReader(reader);
//    String jsonstr=br.readLine();
//    Gson gson=new Gson();
//    int id=gson.fromJson(jsonstr.studentId, Student.class) ;
//    
	}
//    StudentDAO.dataSource=this.dataSource;
//    	Student stud =StudentDAO.getStud(int studentId);
//		GsonBuilder gsonBuilder=new GsonBuilder();
//		Gson gson=gsonBuilder.create();
//		String jsonString=gson.toJson(stud);
//		response.getWriter().print(jsonString);
//		
	
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("hi from student servlet");
	StudentDAO.dataSource= this.dataSource; 
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine();
		System.out.println(jsonString);
		Gson gson=new Gson();
		
		Student stud =gson.fromJson(jsonString, Student.class);
		
		int i=0;
		try {
			i = StudentDAO.addStudent(stud);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i>0) 
		{
			System.out.println("added");
			response.getWriter().write(stud.getStudentId());
		}
		else
		{
			response.getWriter().println("-1");
		}
	}
		/*	System.out.println("request received");
		//to get all employee
		StudentDAO.dataSource=this.dataSource;
		List<Student> list=StudentDAO.getAllStud();
		
		if(list.size()!=0)
		{
			GsonBuilder gsonBuilder=new GsonBuilder();
			Gson gson=gsonBuilder.create();
			String jsonString=gson.toJson(list);
			response.getWriter().print(jsonString);
			
		}
	}*/
		
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
