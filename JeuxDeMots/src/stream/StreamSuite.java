package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSuite {
	
	public static void main(String[] args) {
		List<Voiture> list = generate100NewCars();
		
//		System.out.println(countAllRedOfPorche(list));
		
		removeAllUnknownBrands(list);
	}
	
	public static long countAllRedOfPorche (List<Voiture> list) {
		long total = list.stream().filter(x -> {
			if(x.getCouleur()!=null && x.getMarque()!=null) {
				return  x.getCouleur().equals("Red") && x.getMarque().equals("Porche");
			}
			else {
				return false;
			}
			}).count();
		
		return total;
	}
	
	public static void removeAllUnknownBrands(List<Voiture> list) {
		
		List<Voiture> listWithUnknownRemoveCars = new ArrayList<Voiture>();
		List<Voiture> liste2 =new ArrayList<Voiture>();
		
		//list.stream().filter(x->!x.getMarque().equals("unknown")).forEach(x->System.out.println(x.getMarque()));
		listWithUnknownRemoveCars=list.stream().map(x->{
			if ( x.getMarque()!=null && !x.getMarque().contains("unknown")) { 
				liste2.add(x);	
			}
			return x;
		}).collect(Collectors.toList());
		
		liste2.forEach(a -> System.out.println(a.getMarque()));
		
		
	}
	
 
	
	
	/**
	 * This method generates 100 new random cars.
	 * 
	 * @return list of cars
	 */
	private static List<Voiture> generate100NewCars(){
		List<Voiture> list = new ArrayList<>();
		
		for(int i = 0; i < 100 ; i++) {
			if (i%3==0) {
				list.add(new Voiture("A"+i, "Porche", "Red"));
			} else if (i%5==0) {
				list.add(new Voiture("M"+i, "Jaguar"));
			} else {
				list.add(createCar());
			}
		}
		
		return list;
	}

	/*
	 * Generates a new car
	 * 
	 * @return a car
	 */
	private static Voiture createCar() {
		return new Voiture();
	};
	
}


