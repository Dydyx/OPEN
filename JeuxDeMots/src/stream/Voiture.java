package stream;

import java.util.ArrayList;
import java.util.List;

public class Voiture {
	
	private String name;
	private String marque;
	private String couleur;
	
	public Voiture() {
		this.name = "unknown";
		this.marque = "unknown";
		this.couleur = "unknown";
	}
	
	public Voiture(String name, String marque) {
		this.name = name;
		this.marque = marque;
		this.couleur = null;
	}
	
	public Voiture(String name, String marque, String couleur) {
		this.name = name;
		this.marque = marque;
		this.couleur = couleur;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		return true;
	}
	public static List<Voiture> initial() {
		List<Voiture> list = new ArrayList<>();
		
		list.add(new Voiture("V6", "Lamborgini", "Rouge"));
		list.add(new Voiture("V6", "BMW", "Rouge"));
		list.add(new Voiture("D4", "Jaguar", "Bleu"));
		list.add(new Voiture("S6", null, "Noir"));
		list.add(new Voiture("T5", "Porsche", "Rouge"));
		list.add(new Voiture("V6", "BMW", "Rouge"));
		list.add(new Voiture("V6", null, "vert"));
		
		return list;
	}
	
	public static List<Voiture> createCars() {
		List<Voiture> list = new ArrayList<>();
		
		list.add(new Voiture("V6", "Lamborgini", "Rouge"));
		list.add(new Voiture("V6", "BMW", "Rouge"));
		list.add(new Voiture("D4", "Jaguar", "Bleu"));
		list.add(new Voiture("S6", "Fiat", "Noir"));
		list.add(new Voiture("T5", "Porsche", "Rouge"));
		list.add(new Voiture("V6", "BMW", "Rouge"));
		list.add(new Voiture("V6", "Jaguar", "vert"));
		
		return list;
	}

}
