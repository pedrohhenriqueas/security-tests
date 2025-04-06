package com.example.prol_educa.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dependentes")
public class Dependents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Employees employee;

    @OneToMany(mappedBy = "dependent")
    private List<Applications> applications;

	public Dependents(String name, LocalDate birthDate, Employees employee, List<Applications> applications) {
		this.name = name;
		this.birthDate = birthDate;
		this.employee = employee;
		this.applications = applications;
	}

	public Dependents() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public List<Applications> getApplications() {
		return applications;
	}

	public void setApplications(List<Applications> applications) {
		this.applications = applications;
	}
	
}

