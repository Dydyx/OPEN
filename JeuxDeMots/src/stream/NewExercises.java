package stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NewExercises {
		
	public static void main(String[] args) {
		List<Voiture> list = Voiture.initial(); // touches pas :)
		final List<Voiture> list2 = list;
		
//		System.out.println("Total cars: " + list.size());
//		System.out.println("-------------------");
//		searchForAllRedCars(list).stream().map(x->x.getMarque()).forEach(System.out::println);
//		System.out.println("-------------------");
//		searchForAllBMWCars(list).stream().map(x->x.getMarque()).forEach(System.out::println); // toutes les BMW vont être imprimé
//		System.out.println("-------------------");
		includeUniqueBrands(list).stream().forEach(x -> System.out.println(x.getMarque())); // que des marques uniques
//		System.out.println("-------------------");
//		renameJaguarToFiat(list2).stream().map(x->x.getMarque()).forEach(System.out::println); // renommer jaguar
	}
	
	public static List<Voiture> searchForAllRedCars(List<Voiture> list) {
		return list.stream().filter(x->x.getCouleur().equals("Rouge")).collect(Collectors.toList());
	}
	
	public static List<Voiture> searchForAllBMWCars(List<Voiture> list) {
		
		return list.stream().filter(x->{
				if (x.getMarque()!=null) {
					return x.getMarque().equals("BMW");
				}
				else
				{
					return false;	
				}	
			}
		).collect(Collectors.toList());
		
	} 
	
	
	public static List<Voiture> renameJaguarToFiat(List<Voiture> list) {
		return list.stream().filter(x->{
			if (x.getMarque()!=null) {
				if (x.getMarque().equals("Jaguar")) {
					x.setMarque("Fiat");
				}
				return true;
			} else {
				return false;	
			}
		}
	).collect(Collectors.toList());
	}
	
	public static Set<Voiture> includeUniqueBrands(List<Voiture> list) {
		return new HashSet<>(list);
	}

}
