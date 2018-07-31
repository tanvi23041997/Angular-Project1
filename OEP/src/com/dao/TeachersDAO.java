package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.*;

public class TeachersDAO 
{
	public static DataSource dataSource;
	private static Connection getConnection()
	{
		Connection con=null;
		try {
			con= dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	private static void closeConnection(Connection con)
	{
		try
		{	
			if(con!=null)
			con.close();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}

	public static int addTeacher(Teacher teach) {
		//write code to perform insert operation
		
		Connection con=null;
		String sql = "INSERT INTO TEACHERS_INFO VALUES(teachers_infoauto.nextval,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			con = getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teach.getTeacherName());
			ps.setString(2, teach.getHighQual());
			ps.setString(3, teach.getTeacherEmail());
			ps.setString(4, teach.getTeacherContact());
			ps.setString(5, teach.getTeacherAddress());
			ps.setString(6, teach.getTeacherExperience());
			ps.setString(7, teach.getRating());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
	
	
	public static int deleteTeacher(String  teacherid)
	{
		Teacher teach=null;
		PreparedStatement ps=null;
		Connection con=null;
		int i=0;
		con=getConnection();
		String sql="DELETE from TEACHERS_INFO where TEACHER_ID='"+teacherid+"'";

		try {
			ps = con.prepareStatement(sql);
			i=ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			closeConnection(con);
		}
		return i;
	}
	public static int updateTeacher(Teacher teach,String teacher_id)
	{
		Connection con=null;
		int result = 0;
		try {
			con = getConnection();
			String sql = "UPDATE TEACHERS_INFO SET TEACHER_NAME=?,HIGH_QUAL=?,TEACHER_EMAIL=?,TEACHER_CONTACT=?,TEACHER_ADDRESS=?,TEACHER_EXPERIENCE=?,RATING=? WHERE TEACHER_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, teach.getTeacherName());
			ps.setString(2, teach.getHighQual());
			ps.setString(3, teach.getTeacherEmail());
			ps.setString(4, teach.getTeacherContact());
			ps.setString(5, teach.getTeacherAddress());
			ps.setString(6, teach.getTeacherExperience());
			ps.setString(7, teach.getRating());
			ps.setString(8, teacher_id);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
	public static List<Teacher> getAllTeacher()

	{
		List<Teacher> teacherList=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql = "SELECT TEACHER_ID,TEACHER_NAME,HIGH_QUAL,TEACHER_EMAIL,TEACHER_CONTACT,TEACHER_ADDRESS,TEACHER_EXPERIENCE,RATING from TEACHERS_INFO";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String teacherId =rs.getString(1);
				String teacherName=rs.getString(2);
				String highQual=rs.getString(3);
				String teacherEmail=rs.getString(4);
				String teacherContact=rs.getString(5);
				String teacherAddress=rs.getString(6);
				String teacherExperience=rs.getString(7);
				String rating=rs.getString(8);
				Teacher teach =new Teacher(teacherName,highQual,teacherEmail,teacherContact,teacherAddress,teacherExperience,rating);
				teacherList.add(teach);
			}
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return teacherList;		
	}
	
	public static Teacher getTeacher(String teacherId)

	{
		Teacher teach=null;
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="SELECT TEACHER_ID,TEACHER_NAME,HIGH_QUAL,TEACHER_EMAIL,TEACHER_CONTACT,TEACHER_ADDRESS,TEACHER_EXPERIENCE,RATING from TEACHERS_INFO where TEACHER_ID='"+teacherId+"'";
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				teacherId =rs.getString(1);
				String teacherName=rs.getString(2);
				String highQual=rs.getString(3);
				String teacherEmail=rs.getString(4);
				String teacherContact=rs.getString(5);
				String teacherAddress=rs.getString(6);
				String teacherExperience=rs.getString(7);
				String rating=rs.getString(8);
				teach =new Teacher(teacherName,highQual,teacherEmail,teacherContact,teacherAddress,teacherExperience,rating);
				return teach;
			}		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		return teach;
	}
}
