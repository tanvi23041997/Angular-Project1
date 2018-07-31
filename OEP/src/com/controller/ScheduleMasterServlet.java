package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bo.Course;
import com.bo.ScheduleMaster;
import com.dao.CourseDAO;
import com.dao.ScheduleMasterDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@WebServlet("/schedule")
public class ScheduleMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ScheduleMasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(name="oracledb")
	public static DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleMasterDAO.dataSource=this.dataSource;		
		String crsid = request.getParameter("cid");
		List<ScheduleMaster> list= ScheduleMasterDAO.getScheduleMaster(crsid);
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(list));
	}
		
		//UPDATE TEACHER
		
/*		System.out.println("Put Request Received");
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonstr=br.readLine();	
		Gson gson=new Gson();
		Teacher teach =gson.fromJson(jsonstr, Teacher.class);
		ScheduleMaster sched=null;
		try {
			sched = new ScheduleMaster("L001",3,new java.sql.Date(sdf.parse("25-04-2017").getTime()),new java.sql.Date(sdf.parse("23-05-2017").getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sched);
		ScheduleMasterDAO.updateScheduleMaster(sched);
		//String jstr= "{updatesuccess: 'ok',result="+res+"}";
		//response.getWriter().print(gson.toJson(jstr));*/

	
		
		//DELETE TEACHER 
		
/*		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonstr=br.readLine();	
		Gson gson=new Gson();
		Teacher teach =gson.fromJson(jsonstr, Teacher.class);
		String teacherid=teach.getTeacherId();
		int i=ScheduleMasterDAO.deleteScheduleMaster("L001");
		if(i>0) {System.out.println("Deleted");}
*/
		
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleMasterDAO.dataSource=this.dataSource;		
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine(); 
		System.out.println(jsonString);
		Gson gson=new Gson();
		ScheduleMaster sched=null;
		sched =gson.fromJson(jsonString, ScheduleMaster.class);
		int i=ScheduleMasterDAO.addScheduleMaster(sched);
		if(i>0) 
		{
			System.out.println("added");
			response.getWriter().write(sched.getCourseid());
		}
		else
		{
			response.getWriter().println("-1");
		}
	
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
