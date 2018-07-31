package com.bo;
import java.sql.Date;

public class Payment {
private int	paymentId;
private int	studentId;
private int paymentFor;
private Date paymentDate;
public Payment() {
	super();
}
public Payment(int paymentId, int studentId, int paymentFor, Date paymentDate) {
	super();
	this.paymentId = paymentId;
	this.studentId = studentId;
	this.paymentFor = paymentFor;
	this.paymentDate = paymentDate;
}
public int getPaymentId() {
	return paymentId;
}
public void setPaymentId(int paymentId) {
	this.paymentId = paymentId;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public int getPaymentFor() {
	return paymentFor;
}
public void setPaymentFor(int paymentFor) {
	this.paymentFor = paymentFor;
}
public Date getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
	result = prime * result + paymentFor;
	result = prime * result + paymentId;
	result = prime * result + studentId;
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
	Payment other = (Payment) obj;
	if (paymentDate == null) {
		if (other.paymentDate != null)
			return false;
	} else if (!paymentDate.equals(other.paymentDate))
		return false;
	if (paymentFor != other.paymentFor)
		return false;
	if (paymentId != other.paymentId)
		return false;
	if (studentId != other.studentId)
		return false;
	return true;
}
@Override
public String toString() {
	return "Payment [paymentId=" + paymentId + ", studentId=" + studentId + ", paymentFor=" + paymentFor
			+ ", paymentDate=" + paymentDate + "]";
}



}
