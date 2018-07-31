package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bo.Course;
import com.dao.CourseDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="oracledb")
	public static DataSource dataSource;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDAO.dataSource =this.dataSource;
		//int result=CourseDAO.addCourse(new Course("L002", "MBA", 2, 100000));
		//if(result==1)
		//	System.out.println("Added");
//		List<Course> list = CourseDAO.getAllCourse();
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		List<Course> list=CourseDAO.getAllCourse();
		
		if(list.size()!=0)
		{
			GsonBuilder gsonBuilder=new GsonBuilder();
			Gson gson=gsonBuilder.create();
			String jsonString=gson.toJson(list);
			response.getWriter().print(jsonString);
			
		}
//		CourseDAO.delCourse("L002");
//		List<Course> list = CourseDAO.getAllCourse();
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDAO.dataSource=this.dataSource;
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine();
		Gson gson=new Gson();
		Course sl =gson.fromJson(jsonString, Course.class);
		int i=CourseDAO.addCourse(sl);
		if(i>0) 
		{
			System.out.println("added");
		}
		else
		{
			response.getWriter().println("-1");
		}		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String jstr= "{deletesuccess: 'ok'}";
		Gson gson=new Gson();
		response.sendRedirect(gson.toJson(jstr));
	}

}
