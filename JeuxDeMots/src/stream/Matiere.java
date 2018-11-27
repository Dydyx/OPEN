package stream;

public class Matiere {
	
	String nom;
	Double note;
	
	public Matiere(String nom, Double note) {
		super();
		this.nom = nom;
		this.note = note;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	

}
