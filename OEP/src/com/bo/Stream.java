package com.bo;

public class Stream {
	private String courseId;
	private String streamName;
	public Stream(String courseId, String streamName) {
		super();
		this.courseId = courseId;
		this.streamName = streamName;
	}
	public Stream() {
		super();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((streamName == null) ? 0 : streamName.hashCode());
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
		Stream other = (Stream) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (streamName == null) {
			if (other.streamName != null)
				return false;
		} else if (!streamName.equals(other.streamName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stream [courseId=" + courseId + ", streamName=" + streamName + "]";
	}
	

}
