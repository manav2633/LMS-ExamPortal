package com.exam.portal.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class modules {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int moduleId;
  
  private int sequenceNo;
  
  private int creatorId;
  
  private String courseName;
  
  private String courseCategory;
  
  private String moduleName;
  
  private String moduleDescription;
  
  private int weightage;
  
  

public modules() {
	super();
	// TODO Auto-generated constructor stub
}



public modules(int moduleId, int sequenceNo, int creatorId, String courseName, String courseCategory, String moduleName,
		String moduleDescription, int weightage) {
	super();
	this.moduleId = moduleId;
	this.sequenceNo = sequenceNo;
	this.creatorId = creatorId;
	this.courseName = courseName;
	this.courseCategory = courseCategory;
	this.moduleName = moduleName;
	this.moduleDescription = moduleDescription;
	this.weightage = weightage;
}



public int getModuleId() {
	return moduleId;
}

public void setModuleId(int moduleId) {
	this.moduleId = moduleId;
}

public int getSequenceNo() {
	return sequenceNo;
}

public void setSequenceNo(int sequenceNo) {
	this.sequenceNo = sequenceNo;
}

public int getCreatorId() {
	return creatorId;
}

public void setCreatorId(int creatorId) {
	this.creatorId = creatorId;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getCourseCategory() {
	return courseCategory;
}

public void setCourseCategory(String courseCategory) {
	this.courseCategory = courseCategory;
}

public String getModuleName() {
	return moduleName;
}

public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}

public String getModuleDescription() {
	return moduleDescription;
}

public void setModuleDescription(String moduleDescription) {
	this.moduleDescription = moduleDescription;
}

public int getWeightage() {
	return weightage;
}

public void setWeightage(int weightage) {
	this.weightage = weightage;
}
  
  
  
}
