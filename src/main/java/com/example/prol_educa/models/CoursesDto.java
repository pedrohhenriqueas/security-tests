package com.example.prol_educa.models;

import java.math.BigDecimal;

public class CoursesDto {
	
	private Integer institutions_id;
    private String name;
    private Integer vacancies;
    private BigDecimal percentage_scholarship;
    private BigDecimal original_value;
    private BigDecimal discount_value;
    private String shift;
    private String image_url;
    private BigDecimal discount_entrance;
    private boolean status;


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

	public Integer getInstitutions_id() {
		return institutions_id;
	}

	public void setInstitutions_id(Integer institutions_id) {
		this.institutions_id = institutions_id;
	}

	public CoursesDto(Integer institutions_id, String name, Integer vacancies, BigDecimal percentage_scholarship,
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

	public CoursesDto() {}

}
