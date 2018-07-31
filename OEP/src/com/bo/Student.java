package com.bo;

import java.sql.*;

public class Student {
private	int studentId ;
private	String studentName; 
private	String studentPassword; 
private	String courseId; 
private	String streamName; 
private	String registrationDate; 
private	String guardianName ;
private	String modeOfPayment;
public Student() {
	super();
}
public Student(int studentId, String studentName, String studentPassword, String courseId, String streamName,
		String registrationDate, String guardianName, String modeOfPayment) {
	super();
	System.out.println("constructor");
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentPassword = studentPassword;
	this.courseId = courseId;
	this.streamName = streamName;
	this.registrationDate = registrationDate;
	this.guardianName = guardianName;
	this.modeOfPayment = modeOfPayment;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentPassword() {
	return studentPassword;
}
public void setStudentPassword(String studentPassword) {
	this.studentPassword = studentPassword;
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getStreamName() {
	return streamName;
}
public void setStreamName(String streamName) {
	this.streamName = streamName;
}
public String getRegistrationDate() {
	return registrationDate;
}
public void setRegistrationDate(String registrationDate) {
	System.out.println("setter date");
	this.registrationDate = registrationDate;
}
public String getGuardianName() {
	return guardianName;
}
public void setGuardianName(String guardianName) {
	this.guardianName = guardianName;
}
public String getModeOfPayment() {
	return modeOfPayment;
}
public void setModeOfPayment(String modeOfPayment) {
	this.modeOfPayment = modeOfPayment;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
	result = prime * result + ((guardianName == null) ? 0 : guardianName.hashCode());
	result = prime * result + ((modeOfPayment == null) ? 0 : modeOfPayment.hashCode());
	result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
	result = prime * result + ((streamName == null) ? 0 : streamName.hashCode());
	result = prime * result + studentId;
	result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
	result = prime * result + ((studentPassword == null) ? 0 : studentPassword.hashCode());
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
	Student other = (Student) obj;
	if (courseId == null) {
		if (other.courseId != null)
			return false;
	} else if (!courseId.equals(other.courseId))
		return false;
	if (guardianName == null) {
		if (other.guardianName != null)
			return false;
	} else if (!guardianName.equals(other.guardianName))
		return false;
	if (modeOfPayment == null) {
		if (other.modeOfPayment != null)
			return false;
	} else if (!modeOfPayment.equals(other.modeOfPayment))
		return false;
	if (registrationDate == null) {
		if (other.registrationDate != null)
			return false;
	} else if (!registrationDate.equals(other.registrationDate))
		return false;
	if (streamName == null) {
		if (other.streamName != null)
			return false;
	} else if (!streamName.equals(other.streamName))
		return false;
	if (studentId != other.studentId)
		return false;
	if (studentName == null) {
		if (other.studentName != null)
			return false;
	} else if (!studentName.equals(other.studentName))
		return false;
	if (studentPassword == null) {
		if (other.studentPassword != null)
			return false;
	} else if (!studentPassword.equals(other.studentPassword))
		return false;
	return true;
}
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPassword=" + studentPassword
			+ ", courseId=" + courseId + ", streamName=" + streamName + ", registrationDate=" + registrationDate
			+ ", guardianName=" + guardianName + ", modeOfPayment=" + modeOfPayment + "]";
}



	
	
	
	

}
