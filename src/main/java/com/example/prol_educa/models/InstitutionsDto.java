package com.example.prol_educa.models;

public class InstitutionsDto {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
    private String nameResponsible;
    private String cellResponsible;
    private String emailResponsible;
    private String type;
    private String urlImage;
    private boolean status;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNameResponsible() {
		return nameResponsible;
	}
	public void setNameResponsible(String nameResponsible) {
		this.nameResponsible = nameResponsible;
	}
	public String getCellResponsible() {
		return cellResponsible;
	}
	public void setCellResponsible(String cellResponsible) {
		this.cellResponsible = cellResponsible;
	}
	public String getEmailResponsible() {
		return emailResponsible;
	}
	public void setEmailResponsible(String emailResponsible) {
		this.emailResponsible = emailResponsible;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public InstitutionsDto(String name, String street, String number, String complement, String neighborhood,
			String city, String state, String cep, String nameResponsible, String cellResponsible,
			String emailResponsible, String type, String urlImage, boolean status) {
		this.name = name;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.nameResponsible = nameResponsible;
		this.cellResponsible = cellResponsible;
		this.emailResponsible = emailResponsible;
		this.type = type;
		this.urlImage = urlImage;
		this.status = status;
	}
	public InstitutionsDto() {
	}
	
}
