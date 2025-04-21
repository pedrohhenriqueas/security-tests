package com.example.prol_educa.models;

import java.sql.Date;

public class ScholarshipHoldersDto {

    private Integer customers;
    private String full_name;
    private Date date_of_birth;
    private boolean needs;
    private String cpf;
    private String race_color;


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

	public Integer getCustomers() {
		return customers;
	}

	public void setCustomers(Integer customers) {
		this.customers = customers;
	}
	
	public ScholarshipHoldersDto(Integer customers, String full_name, Date date_of_birth, boolean needs, String cpf,
			String race_color) {
		this.customers = customers;
		this.full_name = full_name;
		this.date_of_birth = date_of_birth;
		this.needs = needs;
		this.cpf = cpf;
		this.race_color = race_color;
	}

	public ScholarshipHoldersDto() {}
    
}
