package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bo.StudentLogin;
import com.bo.TeacherLogin;
import com.dao.StudentLoginDAO;
import com.dao.TeacherLoginDAO;
import com.google.gson.Gson;
@WebServlet("/tlog")
public class LoginTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="oracledb")
	public static DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherLoginDAO.dataSource=this.dataSource;
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader br=new BufferedReader(reader);
		String jsonString=br.readLine();
		Gson gson=new Gson();
		TeacherLogin sl =gson.fromJson(jsonString, TeacherLogin.class);
		
		TeacherLogin i=TeacherLoginDAO.validateUser(sl);
		if(i!=null){
			response.getWriter().write(sl.getUser());
		}
		else {
			response.getWriter().println("-1");
		}
			//		else if(i!=null)
//			response.getWriter().println("0");
			
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
