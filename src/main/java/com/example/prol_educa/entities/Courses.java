package com.example.prol_educa.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Institutions institutions_id;

    @Column(name = "nome")
    private String name;

    @Column(name = "vagas")
    private Integer vacancies;

    @Column(name = "bolsa_percentual")
    private BigDecimal percentage_scholarship;

    @Column(name = "valor_original")
    private BigDecimal original_value;

    @Column(name = "valor_desconto")
    private BigDecimal discount_value;

    @Column(name = "turno")
    private String shift;

    @Column(name = "imagem_url")
    private String image_url;

    @Column(name = "desconto_nentrada")
    private BigDecimal discount_entrance;

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

	public Integer getVacancies() {
		return vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public BigDecimal getPercentage_scholarship() {
		return percentage_scholarship;
	}

	public void setPercentage_scholarship(BigDecimal percentage_scholarship) {
		this.percentage_scholarship = percentage_scholarship;
	}

	public BigDecimal getOriginal_value() {
		return original_value;
	}

	public void setOriginal_value(BigDecimal original_value) {
		this.original_value = original_value;
	}

	public BigDecimal getDiscount_value() {
		return discount_value;
	}

	public void setDiscount_value(BigDecimal discount_value) {
		this.discount_value = discount_value;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public BigDecimal getDiscount_entrance() {
		return discount_entrance;
	}

	public void setDiscount_entrance(BigDecimal discount_entrance) {
		this.discount_entrance = discount_entrance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Institutions getInstitutions_id() {
		return institutions_id;
	}

	public void setInstitutions_id(Institutions institutions_id) {
		this.institutions_id = institutions_id;
	}

	
	
	public Courses(Institutions institutions_id, String name, Integer vacancies, BigDecimal percentage_scholarship,
			BigDecimal original_value, BigDecimal discount_value, String shift, String image_url,
			BigDecimal discount_entrance, boolean status) {
		this.institutions_id = institutions_id;
		this.name = name;
		this.vacancies = vacancies;
		this.percentage_scholarship = percentage_scholarship;
		this.original_value = original_value;
		this.discount_value = discount_value;
		this.shift = shift;
		this.image_url = image_url;
		this.discount_entrance = discount_entrance;
		this.status = status;
	}

	public Courses() {}

}
