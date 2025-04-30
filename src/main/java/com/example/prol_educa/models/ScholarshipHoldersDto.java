package com.example.prol_educa.models;

import java.sql.Date;

public class ScholarshipHoldersDto {

    private Integer customers;
    private String fullName;
    private Date dateOfBirth;
    private boolean needs;
    private String cpf;
    private String raceColor;
	public Integer getCustomers() {
		return customers;
	}
	public void setCustomers(Integer customers) {
		this.customers = customers;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String getRaceColor() {
		return raceColor;
	}
	public void setRaceColor(String raceColor) {
		this.raceColor = raceColor;
	}
	public ScholarshipHoldersDto(Integer customers, String fullName, Date dateOfBirth, boolean needs, String cpf,
			String raceColor) {
		this.customers = customers;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.needs = needs;
		this.cpf = cpf;
		this.raceColor = raceColor;
	}
	public ScholarshipHoldersDto() {
	}
}
