package com.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Auth Samia
 */
@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idetudiant;
	@Column(name = "nom" )
	private String nom;
	@Column(name="pnom" ,nullable=false)
	private String pnom;
	@Column(name="age",nullable=false)
	private Integer age;
	@Column(name="note",nullable=false)
	private Double note;
	
	protected Etudiant() {
	}
	public  Etudiant(String nom, String pnom, Integer age, Double note)
	{
		this.nom=nom;
		this.pnom=pnom;
		this.age=age;
		this.note=note;
	}
	public Long getIdetudiant() {
		return idetudiant;
	}
	public void setIdetudiant(Long idetudiant) {
		this.idetudiant = idetudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPnom() {
		return pnom;
	}
	public void setPnom(String pnom) {
		this.pnom = pnom;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	
	
	
	
}
