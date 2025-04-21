package com.example.prol_educa.models;

import java.sql.Date;


public class CustomersDto {

    private String full_name;
    private String email;
    private String phone;
    private String cpf;
    private Date date_of_birth;
    private boolean status;


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

	public CustomersDto(String full_name, String email, String phone, String cpf, Date date_of_birth, boolean status) {
		this.full_name = full_name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.date_of_birth = date_of_birth;
		this.status = status;
	}

	public CustomersDto() {}
}
