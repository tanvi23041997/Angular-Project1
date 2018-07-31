package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.StudentLogin;
import com.bo.Teacher;
import com.bo.TeacherLogin;

public class TeacherLoginDAO {
	public static DataSource dataSource;
	private static Connection getConnection(){
		Connection con=null;
		try {
			con = dataSource.getConnection();

		} catch (SQLException e) {
			// log
		}
		return con;
	}
	
	private static void closeConnection(Connection con){
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			//log
		}
	}
	
	public static TeacherLogin validateUser(TeacherLogin st) {
		Connection con=null;
		TeacherLogin e = null;
		String username=st.getUser();
		 String password=st.getPassword();
		String sql = "SELECT TEACHER_ID, TEACHER_PASSWORD FROM TEACHERS_INFO WHERE TEACHER_ID=?";
	
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String user = rs.getString(1);
				String pass = rs.getString(2);
				e = new TeacherLogin(user, pass);
			}
			
			rs.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return e;
	}
	
	public static int addTeacherLogin(TeacherLogin sl) {
		Connection con = null;
		String sql = "INSERT INTO TEACHER_LOGIN VALUES(?,?,?)";
		int result = 0;
		try {
			con=getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sl.getUser());
			ps.setString(2, sl.getPassword());
			ps.setString(3, "0");
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// log
		}finally {
			closeConnection(con);
		}
		return result;
	}
	
	public static List<TeacherLogin> getAllTeacher(){
		List<TeacherLogin> crslist = new ArrayList<>();
		
		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql = "select TEACHER_ID,TEACHER_PASSWORD from TEACHER_LOGIN";
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String user = rs.getString(1);
				String password = rs.getString(2);
				crslist.add(new TeacherLogin(user, password));
			}
		} catch (SQLException e) {
			// log
		}
		
		
		return crslist;
		
	}
	
	public static void delTeacher(String teacherId) {

		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql="DELETE FROM TEACHER_LOGIN where TEACHER_ID="+teacherId;
		con=getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			//log
		
		} 
}
}
