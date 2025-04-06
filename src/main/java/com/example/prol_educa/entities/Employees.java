package com.example.prol_educa.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Companies company;

    @OneToMany(mappedBy = "employee")
    private List<Dependents> dependents;

    @OneToMany(mappedBy = "employee")
    private List<Applications> applications;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Companies getCompany() {
		return company;
	}

	public void setCompany(Companies company) {
		this.company = company;
	}

	public List<Dependents> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependents> dependents) {
		this.dependents = dependents;
	}

	public List<Applications> getApplications() {
		return applications;
	}

	public void setApplications(List<Applications> applications) {
		this.applications = applications;
	}

	public Employees(String name, String cpf, String email, String phone, Companies company, List<Dependents> dependents, List<Applications> applications) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.dependents = dependents;
		this.applications = applications;
	}

	public Employees() {
	}
    
}

