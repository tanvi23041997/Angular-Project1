package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.bo.Stream;

public class StreamDAO {
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
	
	public static int addStream(Stream str) {
		Connection con = null;
		String sql = "INSERT INTO STREAM_INFO VALUES(?,?)";
		int result = 0;
		try {
			con=getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, str.getCourseId());
			ps.setString(2, str.getStreamName());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// log
		}finally {
			closeConnection(con);
		}
		return result;
	}
	
	public static List<Stream> getAllStream(){
		List<Stream> strlist = new ArrayList<>();
		
		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql = "select COURSE_ID,STREAM_NAME from STREAM_INFO";
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String courseId = rs.getString(1);
				String streamName = rs.getString(2);
				strlist.add(new Stream(courseId,streamName));
			}
		} catch (SQLException e) {
			// log
		}
		
		
		return strlist;
		
	}
	
	public static List<Stream> getStream(String crsId){
		List<Stream> strlist = new ArrayList<>();
		
		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql = "select COURSE_ID,STREAM_NAME from STREAM_INFO where COURSE_ID='"+crsId+"'";
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String courseId = rs.getString(1);
				String streamName = rs.getString(2);
				strlist.add(new Stream(courseId,streamName));
			}
		} catch (SQLException e) {
			// log
		}
		
		
		return strlist;
		
	}
	
	public static void delStream(String streamName) {

		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql="DELETE FROM STREAM_INFO where STREAM_NAME='"+streamName+"'";
		con=getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			//log
		
		} 
		
	}


}
