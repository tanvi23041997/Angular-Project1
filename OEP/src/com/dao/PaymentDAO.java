package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.bo.Payment;


public class PaymentDAO {
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
	public static int addPaymentDetails(Payment paymt) {
		//write code to perform insert operation
		
		Connection con=null;
		String sql = "INSERT INTO PAYMENT_INFO VALUES(?,?,?,?)";
		int result = 0;
		try {
			con=getConnection();
		//	System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, paymt.getPaymentId());
			ps.setInt(2, paymt.getStudentId());
			ps.setInt(3, paymt.getPaymentFor());
			ps.setDate(4, paymt.getPaymentDate());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
	public static Payment getPay(int studId) {
		Payment paymt=null;
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="SELECT PAYMENT_ID,STUDENT_ID,PAYMENT_FOR,PAYMENT_DATE from PAYMENT_INFO where STUDENT_ID="+studId;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int studid=rs.getInt(2);
				int pid=rs.getInt(1);
				int pf=rs.getInt(3);
				Date pd=rs.getDate(4);
				paymt=new Payment(pid,studid,pf,pd);
				}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
			return 	paymt;
			}	
	}
	
	public static List<Payment> getAllPayDetail(){
		List<Payment> paylist=new ArrayList<>();
		PreparedStatement ps=null;
		Connection con=null;
		con=getConnection();
		String sql="SELECT * from PAYMENT_INFO";
		try {
		ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			int studid=rs.getInt(2);
			int pid=rs.getInt(1);
			int pf=rs.getInt(3);
			Date pd=rs.getDate(4);
			
			paylist.add (new Payment(pid,studid,pf,pd));
		}}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return paylist;
			
		
	}
	public static void deleteAll(int studid) {
		Connection con=null;
		con=getConnection();
		String sql="DELETE from PAYMENT_INFO where STUDENT_ID="+studid;
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
	public static int updatePayment(Payment paymt) {
		int result =0;
		Connection con=null;
		try {
			con=getConnection();
			String sql="UPDATE PAYMENT_INFO SET PAYMENT_ID=?,PAYMENT_FOR=? ,PAYMENT_DATE=?  WHERE STUDENT_ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,paymt.getPaymentId());
			ps.setInt(2,paymt.getStudentId() );
			ps.setInt(3,paymt.getPaymentFor());
			ps.setDate(4,paymt.getPaymentDate());
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
	
}
