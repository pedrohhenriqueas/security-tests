package com.example.prol_educa.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inscricoes")
public class Registrations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "bolsista_id", nullable = false)
    private ScholarshipHolders scholarshipHolders;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Courses courses;
    
    @Column(name = "data_inscricao")
    private Date registration_date;
    
    @Column(name = "status")
    private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ScholarshipHolders getScholarshipHolders() {
		return scholarshipHolders;
	}

	public void setScholarshipHolders(ScholarshipHolders scholarshipHolders) {
		this.scholarshipHolders = scholarshipHolders;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
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

	public Registrations(ScholarshipHolders scholarshipHolders, Courses courses, Date registration_date,
			String status) {
		this.scholarshipHolders = scholarshipHolders;
		this.courses = courses;
		this.registration_date = registration_date;
		this.status = status;
	}

}
