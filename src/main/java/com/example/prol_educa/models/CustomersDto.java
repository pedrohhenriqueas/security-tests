package com.example.prol_educa.models;

import java.sql.Date;


public class CustomersDto {

    private String fullName;
    private String email;
    private String phone;
    private String cpf;
    private Date dateOfBirth;
    private boolean status;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CustomersDto() {}

	public CustomersDto(String fullName, String email, String phone, String cpf, Date dateOfBirth, boolean status) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
	}

	

}
