package com.example.security_tests.models;

public class CustomerRegistrationDto {

	private String name;
	private String email;
	private String confirmationEmail;
	private String password;
	private String confirmationPassword;

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
	public CustomerRegistrationDto() {
		super();
	}
	public CustomerRegistrationDto(String name, String email, String confirmationEmail, String password,
			String confirmationPassword) {
		this.name = name;
		this.email = email;
		this.confirmationEmail = confirmationEmail;
		this.password = password;
		this.confirmationPassword = confirmationPassword;
	}
}
