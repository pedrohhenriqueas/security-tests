package com.example.prol_educa.models;

import java.sql.Date;


public class RegistrationsDto {

    private Integer scholarshipHolderId;
    private Integer courseId;
    private Date registrationDate;
    private String status;
	public Integer getScholarshipHolderId() {
		return scholarshipHolderId;
	}
	public void setScholarshipHolderId(Integer scholarshipHolderId) {
		this.scholarshipHolderId = scholarshipHolderId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RegistrationsDto(Integer scholarshipHolderId, Integer courseId, Date registrationDate, String status) {
		this.scholarshipHolderId = scholarshipHolderId;
		this.courseId = courseId;
		this.registrationDate = registrationDate;
		this.status = status;
	}
	public RegistrationsDto() {
	}
    
}
