package com.bo;

public class Teacher 
{
		private String teacherName;
		private String highQual;
		private String teacherEmail;
		private String teacherContact;
		private String teacherAddress;
		private String teacherExperience;
		private String rating;
		public Teacher() {
			super();
		}
		
		//constructor using fields

		public Teacher(String teacherName, String highQual, String teacherEmail,
				String teacherContact, String teacherAddress, String teacherExperience, String rating) {
			super();
			this.teacherName = teacherName;
			this.highQual = highQual;
			this.teacherEmail = teacherEmail;
			this.teacherContact = teacherContact;
			this.teacherAddress = teacherAddress;
			this.teacherExperience = teacherExperience;
			this.rating = rating;
		}
		
		//toString method
		@Override
		public String toString() {
			return "Teachers [ teacherName=" + teacherName + ", highQual=" + highQual
					+ ", teacherEmail=" + teacherEmail + ", teacherContact=" + teacherContact + ", teacherAddress="
					+ teacherAddress + ", teacherExperience=" + teacherExperience + ", rating=" + rating + "]";
		}
		//getters and setters

		public String getTeacherName() {
			return teacherName;
		}
		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}
		public String getHighQual() {
			return highQual;
		}
		public void setHighQual(String highQual) {
			this.highQual = highQual;
		}
		public String getTeacherEmail() {
			return teacherEmail;
		}
		public void setTeacherEmail(String teacherEmail) {
			this.teacherEmail = teacherEmail;
		}
		public String getTeacherContact() {
			return teacherContact;
		}
		public void setTeacherContact(String teacherContact) {
			this.teacherContact = teacherContact;
		}
		public String getTeacherAddress() {
			return teacherAddress;
		}
		public void setTeacherAddress(String teacherAddress) {
			this.teacherAddress = teacherAddress;
		}
		public String getTeacherExperience() {
			return teacherExperience;
		}
		public void setTeacherExperience(String teacherExperience) {
			this.teacherExperience = teacherExperience;
		}
		public String getRating() {
			return rating;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		
		//hashcode method overriden
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((highQual == null) ? 0 : highQual.hashCode());
			result = prime * result + ((rating == null) ? 0 : rating.hashCode());
			result = prime * result + ((teacherAddress == null) ? 0 : teacherAddress.hashCode());
			result = prime * result + ((teacherContact == null) ? 0 : teacherContact.hashCode());
			result = prime * result + ((teacherEmail == null) ? 0 : teacherEmail.hashCode());
			result = prime * result + ((teacherExperience == null) ? 0 : teacherExperience.hashCode());
			result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
			return result;
		}
		
		//equals method overriden
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Teacher other = (Teacher) obj;
			if (highQual == null) {
				if (other.highQual != null)
					return false;
			} else if (!highQual.equals(other.highQual))
				return false;
			if (rating == null) {
				if (other.rating != null)
					return false;
			} else if (!rating.equals(other.rating))
				return false;
			if (teacherAddress == null) {
				if (other.teacherAddress != null)
					return false;
			} else if (!teacherAddress.equals(other.teacherAddress))
				return false;
			if (teacherContact == null) {
				if (other.teacherContact != null)
					return false;
			} else if (!teacherContact.equals(other.teacherContact))
				return false;
			if (teacherEmail == null) {
				if (other.teacherEmail != null)
					return false;
			} else if (!teacherEmail.equals(other.teacherEmail))
				return false;
			if (teacherExperience == null) {
				if (other.teacherExperience != null)
					return false;
			} else if (!teacherExperience.equals(other.teacherExperience))
				return false;
			if (teacherName == null) {
				if (other.teacherName != null)
					return false;
			} else if (!teacherName.equals(other.teacherName))
				return false;
			return true;
		}
		
}
