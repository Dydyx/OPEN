package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Etudiant {
	
	String name;
	Double noteEtudiant;
	List<Matiere> matiere=new ArrayList<Matiere>();
	
	public Etudiant(String name, Double note, double notePhysique, double noteMath) {		
		this.name = name;
		this.noteEtudiant = note;
		matiere = Arrays.asList(new Matiere("Physique", notePhysique), new Matiere("Math", noteMath));
	}
	public List<Matiere> getMatiere() {
		return matiere;
	}
	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getNoteEtudiant() {
		return noteEtudiant;
	}
	public void setNoteEtudiant(Double note) {
		this.noteEtudiant = note;
	}

}
