package jeuxDeMots;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Jeux {
	
	public static void main(String[] args) {
	
	
		String tosh="toshiba";
				
//		String sousChaine = tosh.substring(0,3);
//		System.out.println(sousChaine);

		
//		System.out.println(tosh.replace("a","x"));
		
		
		test2(tosh);
		digital();
		
		
		
	}
	
	private static void test2(String tosh) {
		
		StringBuilder sb = new StringBuilder(tosh);
		
		System.out.println(sb);
		
		sb.insert(4, "Hello");
		System.out.println(sb);
		sb.append(sb.substring(0, 4));
		sb.delete(0, 4);
		System.out.println(sb);
	}
		

	private static void test(String tosh) {
		StringBuilder sb = new StringBuilder(tosh);
		sb.setCharAt(6, 'x');
		System.out.println(sb);
		
		sb.delete(6, 7);
		System.out.println(sb);
		sb.append('t');
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.insert(4, "Hello");
		System.out.println(sb);
		sb.substring(1, 3);
		sb.delete(0, 4);
		sb.append('t');
		sb.append('b');
		sb.append('i');
		System.out.println(sb);
	}

	private static void digital() {
		StringBuilder sb2 = new StringBuilder("Open Solution Digitale");
		String openSolution = sb2.substring(0, sb2.indexOf("D")).toLowerCase();
		String digitale = sb2.substring(sb2.indexOf("D"), sb2.length()).toUpperCase();
		
		System.out.println("Résultat : " + openSolution + digitale);
		
		
	}	
	public String chercher(int b) {
		return ""+b;
	}
	
	public int chercher2(String c) {
		c = "tata";
		return c.length();
	}

//	public void compterNombreDeMots() {
//		
//		List<String> list = new ArrayList<String>();
//		list.add("subaru");
//		list.add("renault");
//		list.add("peugeotee");
//		list.add("peugeo");
//		int maxE=0;
//		String marqueMax = null;
//		
//		for (int i = 0; i < list.size(); i++) {
//			int nombreE = 0;
//
//			for (int j = 0; j < list.get(i).length(); j++) {
//
//				if (list.get(i).charAt(j) == 'e') {
//					nombreE++;	
//				}
//			}
//			if (nombreE > maxE) {
//				maxE = nombreE;
//				marqueMax = list.get(i);
//			}
//
//		}
//
//		System.out.println(marqueMax);
//	}
	
	
	
	
public void compterNombreDeMots() {
		
		List<String> list = new ArrayList<String>();
		list.add("subaru");
		list.add("renault");
		list.add("peugeotee");
		list.add("peugeo");
		
		transforme(list, (a,j)->a.charAt(j)=='u', (b,c)->b>c);
		transforme(list, (a,j)->a.charAt(j)=='o', (b,c)->b<c);
		
	}
//retourne le mot avec le plus du caractere defini
private void transforme(List<String> list, BiPredicate<String, Integer> predicate, BiPredicate<Integer, Integer> predicate2) {
	Integer maxE=0;
	String marqueMax = null;
	
	for (int i = 0; i < list.size(); i++) {
		int nombreE = 0;

		for (int j = 0; j < list.get(i).length(); j++) {
		

			if (predicate.test(list.get(i),j)) {
				nombreE++;	
			}
		}
		if (nombreE==0 ||predicate2.test(nombreE, maxE)) {
			maxE = nombreE;
			marqueMax = list.get(i);
		}

	}

	System.out.println(marqueMax);
}


	public void voitureAdd() {
		List<String> Voiture = new ArrayList<String>();

		Voiture.add("BMW");
		Voiture.add("Mustang");
		Voiture.add("Fiat");
		Voiture.add("Ferrari");
		System.out.println(Voiture);
		Voiture.add(2, "Porsche");
		System.out.println(Voiture);

	}
	
	
	
	public static Predicate<String> hasLengthOf10 = new Predicate<String>() { 
        @Override
        public boolean test(String t) 
        { 
            return t.length() > 10; 
        } 
    }; 
  
    public static void predicate_or() 
    { 
  
        Predicate<String> containsLetterA = p -> p.contains("A"); 
        String containsA = "End"; 
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA); 
        System.out.println(outcome); 
    } 
    
    public void calculatrice() {
    	calculer(3,4,(a,b)->a+b);
    	calculer(3,4,(a,b)->a*b);
    	
    	binaryOp(3,4,(a,b)->a+b);
    	binaryOp(3,4,(a,b)->a*b);
    }
    
    static void calculer(Integer nombre1, Integer nombre2, BiFunction<Integer, Integer, Integer> funct) {
		System.out.println(funct.apply(nombre1, nombre2));
	}
    
    static void binaryOp(Integer nombre1, Integer nombre2, BinaryOperator<Integer> funct) {
		System.out.println(funct.apply(nombre1, nombre2));
	}
    
    public static Predicate<String> hassLengthOf10 = new Predicate<String>() { 
        @Override
        public boolean test(String t) 
        { 
            return t.length() > 10; 
        } 
    }; 
  
    public static void predicate_negate() 
    { 
  
        String lengthGTThan10 = "Thunderstruck is a 2012 children's "
                                + "film starring Kevin Durant"; 
  
        boolean outcome = hasLengthOf10.negate().test(lengthGTThan10); 
        System.out.println(outcome); 
    } 
    
 
}
