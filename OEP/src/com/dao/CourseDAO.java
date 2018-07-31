package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.bo.Course;

public class CourseDAO {
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
			e.printStackTrace();
		}
	}
	
	public static int addCourse(Course crs) {
		//write code to perform insert operation
		Connection con = null;
		String sql = "INSERT INTO COURSE_INFO VALUES(?,?,?,?)";
		int result = 0;
		try {
			con=getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, crs.getCourseId());
			ps.setString(2, crs.getCourseName());
			ps.setInt(3, crs.getPeriod());
			ps.setDouble(4, crs.getFee());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// log
		}finally {
			closeConnection(con);
		}
		return result;
	}
	
	public static List<Course> getAllCourse(){
		List<Course> crslist = new ArrayList<>();
		
		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql = "select COURSE_ID,COURSE_NAME,PERIOD,COURSE_FEES from COURSE_INFO";
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String courseId = rs.getString(1);
				String courseName = rs.getString(2);
				int coursePeriod = rs.getInt(3);
				double courseFee = rs.getDouble(4);
				crslist.add(new Course(courseId,courseName,coursePeriod,courseFee));
			}
		} catch (SQLException e) {
			// log
		}
		return crslist;
		
	}
	
	public static void delCourse(String courseId) {

		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql="DELETE FROM COURSE_INFO where COURSE_ID='"+courseId+"'";
		con=getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			//log
		
		} 
		
	}
}
