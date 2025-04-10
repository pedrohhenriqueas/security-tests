package com.example.prol_educa.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inscricoes")
public class Registrations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "bolsista_id", nullable = false)
    private ScholarshipHolders scholarshipHolders;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Courses courses;
    
    @Column(name = "data_inscricao")
    private Date registration_date;
    
    @Column(name = "status")
    private String status;
}
