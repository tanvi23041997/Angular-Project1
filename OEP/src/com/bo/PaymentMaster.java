package com.bo;

import java.sql.Date;

public class PaymentMaster {
	private int studentId;
	private double balance; 
	private double totalFee;
	private Date lastPaymentDate;
	private double fine;
	private double totalAmount;
	
	public PaymentMaster() {
		super();
	}
	public PaymentMaster(int studentId, double balance, double totalFee, Date lastPaymentDate, double fine,
			double totalAmount) {
		super();
		this.studentId = studentId;
		this.balance = balance;
		this.totalFee = totalFee;
		this.lastPaymentDate = lastPaymentDate;
		this.fine = fine;
		this.totalAmount = totalAmount;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fine);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastPaymentDate == null) ? 0 : lastPaymentDate.hashCode());
		result = prime * result + studentId;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMaster other = (PaymentMaster) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (Double.doubleToLongBits(fine) != Double.doubleToLongBits(other.fine))
			return false;
		if (lastPaymentDate == null) {
			if (other.lastPaymentDate != null)
				return false;
		} else if (!lastPaymentDate.equals(other.lastPaymentDate))
			return false;
		if (studentId != other.studentId)
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		if (Double.doubleToLongBits(totalFee) != Double.doubleToLongBits(other.totalFee))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentMaster [studentId=" + studentId + ", balance=" + balance + ", totalFee=" + totalFee
				+ ", lastPaymentDate=" + lastPaymentDate + ", fine=" + fine + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
