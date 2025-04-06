package com.example.prol_educa.entities;

import jakarta.persistence.*;
import java.util.List;

import com.example.prol_educa.utils.enuns.EEducationLevels;

@Entity
@Table(name = "bolsas")
public class Scholarships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "desconto")
    private Double discount;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_ensino")
    private EEducationLevels educationLevel;

    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Institutions institution;

    @OneToMany(mappedBy = "scholarship")
    private List<Applications> applications;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public EEducationLevels getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EEducationLevels educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Institutions getInstitution() {
		return institution;
	}

	public void setInstitution(Institutions institution) {
		this.institution = institution;
	}

	public List<Applications> getApplications() {
		return applications;
	}

	public void setApplications(List<Applications> applications) {
		this.applications = applications;
	}

	public Scholarships(String description, Double discount, EEducationLevels educationLevel, Institutions institution, List<Applications> applications) {
		this.description = description;
		this.discount = discount;
		this.educationLevel = educationLevel;
		this.institution = institution;
		this.applications = applications;
	}

	public Scholarships() {
	}
    
}

