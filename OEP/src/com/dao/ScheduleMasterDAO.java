package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.ScheduleMaster;

public class ScheduleMasterDAO 
{
	static SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
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
	public static int addScheduleMaster(ScheduleMaster sched) {
		//write code to perform insert operation
		
		Connection con=null;
		String sql = "INSERT INTO SCHEDULE_MASTER VALUES(?,?,?,?,?)";
		int result = 0;
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,sched.getCourseid()+sched.getSemester()); 
			ps.setString(2,sched.getCourseid()); 
			ps.setInt(3,sched.getSemester());
			ps.setDate(4,new java.sql.Date(sdf.parse(sched.getStart_date()).getTime()));
			ps.setDate(5, new java.sql.Date(sdf.parse(sched.getEnd_date()).getTime()));
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
	public static List<ScheduleMaster> getScheduleMaster(String courseid )
	{
		List<ScheduleMaster> ScheduleMasterList=new ArrayList<>();
		ScheduleMaster sched=null;
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="SELECT COURSE_ID,SEMESTER,START_DATE,END_DATE from SCHEDULE_MASTER where COURSE_ID='"+courseid+"'";
		try {
			ps=con.prepareStatement(sql);
			//ps.setInt(1,empid);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				courseid=rs.getString(1);
				int semester=rs.getInt(2);
				String start_date=sdf.format(rs.getDate(3));
				String end_date=sdf.format(rs.getDate(4));
				sched =new ScheduleMaster(courseid,semester,start_date,end_date);
				ScheduleMasterList.add(sched);
			}		
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		return ScheduleMasterList;
	}
	
	public static List<ScheduleMaster> getAllScheduleMaster()

	{
		List<ScheduleMaster> ScheduleMasterList=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql = "SELECT COURSE_ID,SEMESTER,START_DATE,END_DATE from SCHEDULE_MASTER";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String courseId =rs.getString(1);
				int semester=rs.getInt(2);
				String start_date=sdf.format(rs.getDate(3));
				String end_date=sdf.format(rs.getDate(4));

				ScheduleMaster sched =new ScheduleMaster(courseId,semester,start_date,end_date);
				ScheduleMasterList.add(sched);
			}
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		return ScheduleMasterList;		
	}

	public static int deleteScheduleMaster(String courseid)
	{
		ScheduleMaster sched=null;
		PreparedStatement ps=null;
		Connection con=null;
		int result=0;
		con=getConnection();
		String sql="DELETE from SCHEDULE_MASTER where COURSE_ID='"+courseid+"'";

		try {
			ps = con.prepareStatement(sql);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return result;
	}
	
	public static int updateScheduleMaster(ScheduleMaster sched)
	{
		Connection con=null;
		int result = 0;
		try {
			con = getConnection();
			String sql = "UPDATE SCHEDULE_MASTER SET SEMESTER=?,START_DATE=?,END_DATE=? WHERE COURSE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,sched.getSemester());
			ps.setDate(2,new java.sql.Date(sdf.parse(sched.getEnd_date()).getTime()));
			ps.setDate(3,new java.sql.Date(sdf.parse(sched.getEnd_date()).getTime()));
			ps.setString(4,sched.getCourseid());
			
			result = ps.executeUpdate();
			
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
}
