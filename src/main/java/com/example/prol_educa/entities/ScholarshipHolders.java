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
@Table(name = "Bolsistas")
public class ScholarshipHolders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Customers customers;

    @Column(name = "nome_completo")
    private String full_name;

    @Column(name = "data_nascimento")
    private Date date_of_birth;

    @Column(name = "necessidades")
    private boolean needs;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "raca_cor")
    private String race_color;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public boolean isNeeds() {
		return needs;
	}

	public void setNeeds(boolean needs) {
		this.needs = needs;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRace_color() {
		return race_color;
	}

	public void setRace_color(String race_color) {
		this.race_color = race_color;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	public ScholarshipHolders(Customers customers, String full_name, Date date_of_birth, boolean needs, String cpf,
			String race_color) {
		this.customers = customers;
		this.full_name = full_name;
		this.date_of_birth = date_of_birth;
		this.needs = needs;
		this.cpf = cpf;
		this.race_color = race_color;
	}

	public ScholarshipHolders() {}
    
}
