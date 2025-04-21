package com.example.prol_educa.models;

import java.sql.Date;


public class RegistrationsDto {

    private Integer scholarshipHolder_id;
    private Integer course_id;
    private Date registration_date;
    private String status;

	public Integer getScholarshipHolders() {
		return scholarshipHolder_id;
	}

	public void setScholarshipHolders(Integer scholarshipHolder_id) {
		this.scholarshipHolder_id = scholarshipHolder_id;
	}

	public Integer getCourses() {
		return course_id;
	}

	public void setCourses(Integer course_id) {
		this.course_id = course_id;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RegistrationsDto(Integer scholarshipHolder_id, Integer course_id, Date registration_date,
			String status) {
		this.scholarshipHolder_id = scholarshipHolder_id;
		this.course_id = course_id;
		this.registration_date = registration_date;
		this.status = status;
	}

	public RegistrationsDto() {
	}
}
