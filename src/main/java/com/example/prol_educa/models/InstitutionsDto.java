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
	    private String name_responsible;
	    private String cell_responsible;
	    private String email_responsible;
	    private String type;
	    private String url_image;
	    private boolean status;
	    
		public InstitutionsDto(String name, String street, String number, String complement, String neighborhood,
				String city, String state, String cep, String name_responsible, String cell_responsible,
				String email_responsible, String type, String url_image, boolean status) {
			this.name = name;
			this.street = street;
			this.number = number;
			this.complement = complement;
			this.neighborhood = neighborhood;
			this.city = city;
			this.state = state;
			this.cep = cep;
			this.name_responsible = name_responsible;
			this.cell_responsible = cell_responsible;
			this.email_responsible = email_responsible;
			this.type = type;
			this.url_image = url_image;
			this.status = status;
			
		}
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
		public String getName_responsible() {
			return name_responsible;
		}
		public void setName_responsible(String name_responsible) {
			this.name_responsible = name_responsible;
		}
		public String getCell_responsible() {
			return cell_responsible;
		}
		public void setCell_responsible(String cell_responsible) {
			this.cell_responsible = cell_responsible;
		}
		public String getEmail_responsible() {
			return email_responsible;
		}
		public void setEmail_responsible(String email_responsible) {
			this.email_responsible = email_responsible;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUrl_image() {
			return url_image;
		}
		public void setUrl_image(String url_image) {
			this.url_image = url_image;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		} 
	  
}
