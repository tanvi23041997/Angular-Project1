package com.bo;

import java.sql.Date;

public class ScheduleMaster
{
	private String courseid;
	private int semester;
	private String start_date;
	private String end_date;
	public ScheduleMaster(String courseid, int semester, String start_date, String end_date) {
		super();
		this.courseid = courseid;
		this.semester = semester;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "ScheduleMaster [courseid=" + courseid + ", semester=" + semester + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseid == null) ? 0 : courseid.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + semester;
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode()); 
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
		ScheduleMaster other = (ScheduleMaster) obj;
		if (courseid == null) {
			if (other.courseid != null)
				return false;
		} else if (!courseid.equals(other.courseid))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (semester != other.semester)
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}
	
}
