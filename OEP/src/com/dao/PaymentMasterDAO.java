package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.PaymentMaster;

public class PaymentMasterDAO {

	public static DataSource dataSource;
	private static Connection getConnection(){
		Connection con=null;
		try {
			con = dataSource.getConnection();
			//System.out.println(con);

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
	
	public static int addStream(PaymentMaster pm) {
		//write code to perform insert operation
		Connection con = null;
		String sql = "INSERT INTO PAYMENT_MASTER VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			con=getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pm.getStudentId());
			ps.setDouble(2, pm.getBalance());
			ps.setDouble(3,pm.getTotalFee());
			ps.setDate(4,pm.getLastPaymentDate());
			ps.setDouble(5,pm.getFine());
			ps.setDouble(6, pm.getTotalAmount());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// log
		}finally {
			closeConnection(con);
		}
		return result;
	}
	
	public static List<PaymentMaster> getAllStream(){
		List<PaymentMaster> strlist = new ArrayList<>();
		
		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql = "select STUDENT_ID,BALANCE,TOTAL_FEE,LAST_PAYMENT_DATE,FINE,TOTAL_AMOUNT from PAYMENT_MASTER";
		
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int  studentId= rs.getInt(1);
				double balance = rs.getDouble(2);
				double totalFee = rs.getDouble(3);
				Date lastPaymentDate = rs.getDate(4);
				double fine = rs.getDouble(5);
				double totalAmount = rs.getDouble(6);

				strlist.add(new PaymentMaster(studentId, balance, totalFee, lastPaymentDate, fine, totalAmount));
			}
		} catch (SQLException e) {
			// log
		}
		
		
		return strlist;
		
	}
	
	public static void delCourse(String studentId) {

		PreparedStatement ps= null;
		Connection con=null;
		con=getConnection();
		
		String sql="DELETE FROM PAYMENT_MASTER where STUDENT_ID="+studentId;
		con=getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			//log
		
		} 
		
	}

}
