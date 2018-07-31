package com.dao;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.bo.Student;

public class StudentDAO {
	public  static DataSource dataSource;
	private static Connection getConnection() {
		 Connection con=null;
		try {
		con=dataSource.getConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		return con;
		}
	private static void closeConnection(Connection con) {
		try {
		if(con!=null) {
			con.close();
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	public static int addStudent(Student stud) throws ParseException {
		//write code to perform insert operation
		
		Connection con=null;
		String sql = "INSERT INTO STUDENT_INFO VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			con=getConnection();
		//	System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,stud.getStudentId());
			ps.setString(2, stud.getStudentName());
			ps.setString(3, stud.getStudentPassword());
			ps.setString(4, stud.getCourseId());
			ps.setString(5, stud.getStreamName());
			ps.setDate(6, new java.sql.Date(sdf.parse(stud.getRegistrationDate()).getTime()));
			ps.setString(7, stud.getGuardianName());
			ps.setString(8, stud.getModeOfPayment());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
	public static Student getStud(int studentId) {
		//to get the details of one student 
		Student stud=null;
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String sql="SELECT STUDENT_ID,STUDENT_NAME,STUDENT_PASSWORD,COURSE_ID,STREAM_NAME,REGISTRATION_DATE,GUARDIAN_NAME, MODE_OF_PAYMENT,from STUDENT_INFO where STUDENT_ID="+studentId;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				int sid= rs.getInt("studentId");
				String sname=rs.getString(2); 
				String spass= rs.getString(3);
				String cid=rs.getString(4); 
				String stname= rs.getString(5);
				String regdate= sdf.format(rs.getDate(6));
				String gname=rs.getString(7);
				String mop=rs.getString(8);
				stud=new Student(sid,sname,spass,cid,stname,regdate,gname,mop);

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
			return 	stud;
			}	
	}
	public static List<Student> getAllStud(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		List<Student> studlist=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="SELECT * from STUDENT_INFO";
		try {
		ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			//int sid= rs.getInt("studentId");
			int sid= rs.getInt(1);
			String sname=rs.getString(2); 
			String spass= rs.getString(3);
			String cid=rs.getString(4); 
			String stname= rs.getString(5);
			String regdate= sdf.format(rs.getDate(6));
			String gname=rs.getString(7);
			String mop=rs.getString(8);
			studlist.add(new Student(sid,sname,spass,cid,stname,regdate,gname,mop));
			
		}}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return studlist;
					
	}
	public static int updateStudent(Student stud) throws ParseException {
		int result =0;
		Connection con=null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {
			con=getConnection();
			String sql="UPDATE STUDENT_INFO SET STUDENT_NAME=?,STUDENT_PASSWORD=?,COURSE_ID=?, STREAM_NAME=?, REGISTRATION_DATE=?, GUARDIAN_NAME=?,MODE_OF_PAYMENT=? WHERE STUDENT_ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, stud.getStudentName());
			ps.setString(2, stud.getStudentPassword());
			ps.setString(3, stud.getCourseId());
			ps.setString(4, stud.getStreamName());
			ps.setDate(5, new java.sql.Date(sdf.parse(stud.getRegistrationDate()).getTime()));
			ps.setString(6, stud.getGuardianName());
			ps.setString(7, stud.getModeOfPayment());
			ps.setInt(8, stud.getStudentId());
			result=ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		return result;
	}
	public static void deleteAll(int studentId) {
		Connection con=null;
		con=getConnection();
		String sql="DELETE from STUDENT_INFO where STUDENT_INFO="+studentId;
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			int result=ps.executeUpdate();
			if(result>0) {
				System.out.println("deleted");
			}
			else {
				System.out.println("not deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
