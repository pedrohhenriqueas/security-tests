package com.example.prol_educa.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name = "nome_completo")
    private String full_name;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private Date date_of_birth;

    @Column(name = "status")
    private boolean status;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customers(String full_name, String email, String phone, String cpf, Date date_of_birth, boolean status) {
		this.full_name = full_name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.date_of_birth = date_of_birth;
		this.status = status;
	}

	public Customers() {}
    
}
