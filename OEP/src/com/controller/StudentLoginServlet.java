package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bo.Course;
import com.bo.StudentLogin;
import com.dao.CourseDAO;
import com.dao.StudentLoginDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/slogin")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="oracledb")
	public static DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentLoginDAO.dataSource=this.dataSource;
		List<StudentLogin> list=StudentLoginDAO.getAllStudentLogin();
		
		if(list.size()!=0)
		{
			GsonBuilder gsonBuilder=new GsonBuilder();
			Gson gson=gsonBuilder.create();
			String jsonString=gson.toJson(list);
			response.getWriter().print(jsonString);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentLoginDAO.dataSource=this.dataSource;
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine();
		Gson gson=new Gson();
		StudentLogin sl =gson.fromJson(jsonString, StudentLogin.class);
		int i=StudentLoginDAO.addStudentLogin(sl);
		if(i>0) 
		{
			System.out.println("added");
			response.getWriter().write(sl.getUser());
		}
		else
		{
			response.getWriter().println("-1");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		}
	
	

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	StudentLoginDAO.dataSource=this.dataSource;
	InputStreamReader reader=new InputStreamReader(request.getInputStream());
	BufferedReader br=new BufferedReader(reader);
	String jsonString=br.readLine();
	Gson gson=new Gson();
	StudentLogin sl =gson.fromJson(jsonString, StudentLogin.class);
	int i=StudentLoginDAO.delStudentLogin(sl.getUser());
	if(i>0) 
	{
		System.out.println("Deleted");
		response.getWriter().write(sl.getUser());
	}
	else
	{
		response.getWriter().println("-1");
	}	
	}
}
