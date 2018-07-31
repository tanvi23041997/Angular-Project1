package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.bo.StudentLogin;

public class StudentLoginDAO {

	public static DataSource dataSource;
	private static Connection getConnection(){
		Connection con=null;
		if(con==null)
			try {
			con = dataSource.getConnection();
			} catch (SQLException e) {}
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
	
	public static StudentLogin validateUser(StudentLogin st) {
		Connection con=null;
		StudentLogin e = null;
		String username=st.getUser();
		 String password=st.getPassword();
		String sql = "SELECT STUDENT_ID, STUDENT_PASSWORD FROM STUDENT_LOGIN WHERE STUDENT_ID=?";
	
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String user = rs.getString(1);
				String pass = rs.getString(2);
				e = new StudentLogin(user, pass);
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

	
	public static int addStudentLogin(StudentLogin sl) {
		Connection con=null;
		String sql = "INSERT INTO STUDENT_LOGIN VALUES(?,?)";
		int result = 0;
		try {
			con=getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sl.getUser());
			ps.setString(2, sl.getPassword());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// log
		}finally {
			closeConnection(con);
		}
		return result;
	}
	
	public static List<StudentLogin> getAllStudentLogin(){
		List<StudentLogin> crslist = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps= null;
		con=getConnection();
		
		String sql = "select STUDENT_ID,STUDENT_PASSWORD from STUDENT_LOGIN";
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String user = rs.getString(1);
				String password = rs.getString(2);
				crslist.add(new StudentLogin(user, password));
			}
		} catch (SQLException e) {
			// log
		}finally {
			closeConnection(con);
		}
		
		
		return crslist;
		
	}
	
	public static int delStudentLogin(String studentId) {
		Connection con=null;

		PreparedStatement ps= null;
		con=getConnection();
		int rs=0;
		
		String sql="DELETE FROM STUDENT_LOGIN where STUDENT_ID="+studentId;
		con=getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeUpdate();
		} catch (SQLException e) {
			
			//log
		
		} finally {
			closeConnection(con);
		}
		return rs;
		
	}

}
