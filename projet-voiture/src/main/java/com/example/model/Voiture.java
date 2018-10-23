/**
 * 
 */
package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dylan
 *
 */
@Entity
@Table(name = "voiture")
public class Voiture implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "marque")
	private String marque;

	@Column(name = "modele")
	private String modele;

	@Column(name = "annee")
	private int annee;

	@Column(name = "prix")
	private int prix;


	protected Voiture() {
	}

	public Voiture(String marque, String modele, int annee, int prix) {
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, marque='%s', modele='%s', annee='%s', prix='%s']", id, marque, modele, annee, prix);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

}
