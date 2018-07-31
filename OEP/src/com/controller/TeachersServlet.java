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

import com.bo.*;
import com.dao.TeachersDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/TeachersServlet")
public class TeachersServlet extends HttpServlet {
	
	@Resource(name="oracledb")
	public static DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeachersDAO.dataSource=this.dataSource;
		
	
		
		
		//GET ALL TEACHERS
		
/*		System.out.println("request received");
		//to get all employee		
		List<Teacher> list=TeachersDAO.getAllTeacher();
		if(list.size()!=0)
		{
			GsonBuilder gsonBuilder=new GsonBuilder();
			Gson gson=gsonBuilder.create();
			String jsonString=gson.toJson(list);
			response.getWriter().print(jsonString);
		}
*/
	
		


	
		
		//DELETE TEACHER (working)
		
/*		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonstr=br.readLine();	
		Gson gson=new Gson();
		Teacher teach =gson.fromJson(jsonstr, Teacher.class);
		String teacherid=teach.getTeacherId();
		int i=TeachersDAO.deleteTeacher("1");
		if(i>0) {System.out.println("Deleted");}
*/
		
		
		//GET TEACHER(not working)
		
/*		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonstr=br.readLine();	
		Gson gson=new Gson();
		// teach =gson.fromJson(jsonstr, Teacher.class);
		//String teacherid=teach.getTeacherId();
		Teacher  teach=TeachersDAO.getTeacher("1");
		System.out.println(teach);	
*/	
	
	}	
		
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//ADD TEACHERS
			
					InputStreamReader reader=new InputStreamReader(request.getInputStream());
					BufferedReader br=new BufferedReader(reader);
					String jsonString=br.readLine();
					System.out.println(jsonString);
					Gson gson=new Gson();
					Teacher teach =gson.fromJson(jsonString, Teacher.class);
					
					//Teacher teach=new Teacher("1","shipra","mtech","fsdg","53767","a-19","erfdg","3");
					System.out.println("hello");
					System.out.println(teach);
					
					int i=TeachersDAO.addTeacher(teach);	
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
			//UPDATE TEACHER
			
			System.out.println("Put Request Received");
			InputStreamReader reader=new InputStreamReader(request.getInputStream());
			BufferedReader br=new BufferedReader(reader);
			String jsonstr=br.readLine();	
			Gson gson=new Gson();
			Teacher teach =gson.fromJson(jsonstr, Teacher.class);
			//Teacher teach=new Teacher("1","tanvi","mtech","fsdg","53767","a-19","erfdg","3");
			System.out.println(teach);
			int res=TeachersDAO.updateTeacher(teach,"2");
			String jstr= "{updatesuccess: 'ok',result="+res+"}";
			response.getWriter().print(gson.toJson(jstr));
		}
}
