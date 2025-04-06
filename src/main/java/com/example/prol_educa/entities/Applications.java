package com.example.prol_educa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aplicacoes")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bolsa_id")
    private Scholarships scholarship;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = true)
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "dependente_id", nullable = true)
    private Dependents dependent;

    @Column(name = "data_aplicacao")
    private LocalDateTime applicationDate = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Scholarships getScholarship() {
		return scholarship;
	}

	public void setScholarship(Scholarships scholarship) {
		this.scholarship = scholarship;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Dependents getDependent() {
		return dependent;
	}

	public void setDependent(Dependents dependent) {
		this.dependent = dependent;
	}

	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Applications(Scholarships scholarship, Employees employee, Dependents dependent, LocalDateTime applicationDate) {
		this.scholarship = scholarship;
		this.employee = employee;
		this.dependent = dependent;
		this.applicationDate = applicationDate;
	}

	public Applications() {
	}
        
}

