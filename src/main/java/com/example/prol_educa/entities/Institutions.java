package com.example.prol_educa.entities;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "instituicoes")
public class Institutions {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String name;
    
    @Column(name = "rua")
    private String street;
    
    @Column(name = "numero")
    private String number;
    
    @Column(name = "complemento")
    private String complement;
    
    @Column(name = "bairro")
    private String neighborhood;
    
    @Column(name = "cidade")
    private String city;
    
    @Column(name = "estado")
    private String state;

    @Column(name = "cep")
    private String cep;
    
    @Column(name = "responsavel_nome")
    private String nameResponsible;
    
    @Column(name = "responsavel_tel")
    private String cellResponsible;
    
    @Column(name = "responsavel_email")
    private String emailResponsible;
    
    @Column(name = "tipo")
    private String type;
    
    @Column(name = "imagem_url")
    private String urlImage;
    
    @JsonIgnore
    private String password;
    
    @Column(name = "status")
    private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Institutions(String name, String street, String number, String complement, String neighborhood, String city,
			String state, String cep, String nameResponsible, String cellResponsible, String emailResponsible,
			String type, String urlImage, String password, boolean status) {
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
		this.password = password;
		this.status = status;
	}

	public Institutions() {
	}
    	
}

