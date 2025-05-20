package com.example.prol_educa.models;

import java.util.Date;

public class CustomerRegistrationDto {

	private String name;
	private String email;
	private String confirmationEmail;
	private String password;
	private String confirmationPassword;
	private String cpf;
	private Date dateOfBirth;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmationEmail() {
		return confirmationEmail;
	}
	public void setConfirmationEmail(String confirmationEmail) {
		this.confirmationEmail = confirmationEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmationPassword() {
		return confirmationPassword;
	}
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public CustomerRegistrationDto() {
		super();
	}
	public CustomerRegistrationDto(String name, String email, String confirmationEmail, String password,
			String confirmationPassword, String cpf, Date dateOfBirth, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.confirmationEmail = confirmationEmail;
		this.password = password;
		this.confirmationPassword = confirmationPassword;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}
}
