package com.example.prol_educa.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "instituicoes")
public class Institutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "endereco")
    private String address;

    @Column(name = "contato")
    private String contact;

    @OneToMany(mappedBy = "institution")
    private List<Scholarships> scholarships;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Scholarships> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarships> scholarships) {
		this.scholarships = scholarships;
	}

	public Institutions(String name, String address, String contact, List<Scholarships> scholarships) {
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.scholarships = scholarships;
	}

	public Institutions() {
	}
    
}

