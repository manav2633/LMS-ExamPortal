package com.exam.portal.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class course {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int courseId;
	private int creatortid;
	private String courseName;
	private String courseAbbrevation;
	private String courseDescription;
	private String courseCategory;
	private Date createdDate;
	
	public course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public course(int courseId, int creatortid, String courseName, String courseAbbrevation, String courseDescription,
			String courseCategory, Date createdDate) {
		super();
		this.courseId = courseId;
		this.creatortid = creatortid;
		this.courseName = courseName;
		this.courseAbbrevation = courseAbbrevation;
		this.courseDescription = courseDescription;
		this.courseCategory = courseCategory;
		this.createdDate = createdDate;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCreatortid() {
		return creatortid;
	}

	public void setCreatortid(int creatortid) {
		this.creatortid = creatortid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseAbbrevation() {
		return courseAbbrevation;
	}

	public void setCourseAbbrevation(String courseAbbrevation) {
		this.courseAbbrevation = courseAbbrevation;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	

}
