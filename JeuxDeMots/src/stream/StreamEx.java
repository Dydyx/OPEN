package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamEx {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	int a1 = 0;
	int a2;
	Integer b;
	boolean c;
	Boolean d;

	static Etudiant etudiant1 = new Etudiant("Mathieu", 12.4, 16, 17);
	static Etudiant etudiant2 = new Etudiant("Mickeal", 16.3, 14, 8);
	static Etudiant etudiant3 = new Etudiant("Ranto", 10.0, 12, 6);

	static Etudiant etudiant4 = new Etudiant("Mickey", 13.1, 2, 12);
	static Etudiant etudiant5 = new Etudiant("Cendrillon", 8.9, 3, 7);
	static Etudiant etudiant6 = new Etudiant("Santa", null, 12, 6);

	static List<Etudiant> one = Arrays.asList(etudiant1, etudiant2, etudiant3);
	static List<Etudiant> two = Arrays.asList(etudiant4, etudiant5, etudiant6);

	public StreamEx() {

	}

	public static List<Voiture> ajoutVoiture() {

		List<Voiture> voit = new ArrayList<Voiture>();
		voit.add(new Voiture("V6", "Lamborgini", "Rouge"));
		voit.add(new Voiture("V6", "BMW", "Rouge"));
		voit.add(new Voiture("D4", "Jaguar", "Bleu"));
		voit.add(new Voiture("S6", "Ferrari", "Noir"));
		voit.add(new Voiture("T5", "Porsche", "Rouge"));
		voit.add(new Voiture("V6", "BMW", "Vert"));

		return voit;
	}

	public static void selectRouge(List<Voiture> voit) {

		for (int i = 0; i < voit.size(); i++) {
			if (voit.get(i).getCouleur().equals("Rouge")) {
				System.out.println(voit.get(i).getMarque());
			}
		}
	}

	public static void selectRouge45(List<Voiture> voit2) {
		voit2.stream().filter(x -> x.getCouleur().equals("Rouge")).forEach(x -> System.out.println(x.getMarque()));

	}

	// modif pour test unitaire
	public List<Voiture> selectRouge3(List<Voiture> voit2) {
		List<Voiture> liste = new ArrayList<>();

		liste = voit2.stream().filter(x -> x.getCouleur().equals("Rouge")).collect(Collectors.toList());
		return liste;
	}

	public static void streamTest4() {
		Stream<String> s = Stream.of("duck", "dack", "duck", "goose");
		s.distinct().forEach(x -> System.out.print(" " + x));
	}

	public static void selectRouge5(List<Voiture> voit2) {
		voit2.stream().filter(x -> x.getCouleur().equals("Rouge")).limit(2)
				.forEach(x -> System.out.println(x.getMarque()));

	}

	public static void selectRouge6(List<Voiture> voit2) {
		voit2.stream().filter(x -> x.getCouleur().equals("Rouge")).skip(2).limit(2)
				.forEach(x -> System.out.println(x.getMarque()));

	}

	public static void selectRouge7(List<Voiture> voit2) {
		voit2.stream().map(Voiture::getName).forEach(System.out::print);

	}

	public static void main(String[] args) {
		List<Voiture> voit = ajoutVoiture();
		Stream<List<Etudiant>> list = Stream.of(one, two);
//		selectRouge7(voit);
//		streamTest();
//	compterElement();
//		streamTest2();
//		moyenneNotePhystiqueAllEtudiant3();
//		AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael2();
		// selectRouge3();
		// reduceMethod4();
		// streamTest49();
//		streamTest28();
//	compterNombreDeMotsE();
//		reduceMethod();
//		stringBuilderTest("renault");
//	stringBuilderTest3("renault");
		// varTest() ;
		// streamTest55();
		// optionalTest2();
		// notePlusFaible();
		// moyenneNoteClasse();
		// noteFois5();
		// nomQuiPossedeMick(list);
		// EtudiantNoteMathSup10();
//		etudiantMickeySappelNowJess(list);
//		moyenneNotePhystiqueAllEtudiant();
		// moyenneDeToutesLesNotesMathsEtPhysique();
		// moyenneDeToutesLesNotesMathsEtPhysique2();
//		afficherEtudiantQuiOnt1NoteInferieurA10();
//		etudiantMickeyMoins5PointsNoteSupEtInf10();
//		StreamEx stream = new StreamEx();
//		stream.moyenneDeToutesLesNotesMathsEtPhysiqueSansCendrillion();

	}

	public static void streamTest() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(x -> x.startsWith("m")).forEach(System.out::print);
	}

	// pour test unitaire
	public List<String> streamTest90() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");

		return s.filter(x -> x.startsWith("m")).collect(Collectors.toList());

	}

	public static void compterElement() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s.filter(x -> x.startsWith("m")).count());
	}

	public static void streamTest2() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(x -> x.contains("k")).forEach(System.out::print);
	}

	public static void streamTest3() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(x -> x.contains("n") && !x.contains("k")).forEach(System.out::print);
	}

	public static void streamTest5() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(String::length).forEach(System.out::print);
	}

	public static void streamTest6() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(x -> x.length()).forEach(System.out::print);
	}

	public static void streamTest8() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(x -> {
			StringBuilder sb = new StringBuilder(x);
			return sb.reverse().toString();
		}).forEach(System.out::print);
	}

	// function
//	String apply(String element) {
//		StringBuilder sb = new StringBuilder(element);
//		return sb.reverse().toString();
//	}

	public static void streamTest7() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(x -> {
			StringBuilder sb = new StringBuilder(x);
			return sb.reverse().toString();

		}).forEach(x -> System.out.print(" " + x));
	}

	public static void streamTest11() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(x -> {
			StringBuilder sb = new StringBuilder(x);
			return sb.append("c").toString();
		}).forEach(x -> System.out.print(" " + x));
	}

	public static void streamTest10() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(x -> {
			StringBuilder sb = new StringBuilder(x);
			return sb.insert(2, 3).toString();

		}).forEach(x -> System.out.print(" " + x));
	}

	public static void stringBuilderTest10(String nomVoit) {
		StringBuilder sb = new StringBuilder(nomVoit);
		System.out.println(sb.append("subaru"));
	}

	public static void stringBuilderTest2(String nomVoit) {
		String resultat = nomVoit + "essai";
		resultat += "test";
		System.out.println(resultat);
	}

	public static void stringBuilderTest5(String nomVoit) {
		StringBuilder sb = new StringBuilder();
		sb.append(nomVoit);
		sb.append("subaru").append("porsche");
		System.out.println(sb);
		System.out.println(sb.toString());
	}

	public static void stringBuilderTest(String nomVoit) {
		StringBuilder sb = new StringBuilder(nomVoit);
		System.out.println(sb.replace(1, 3, "subaru"));
	}

	public static void stringBuilderTest3(String nomVoit) {
		StringBuilder sb = new StringBuilder();
		sb.append(nomVoit);
		sb.append("subaru" + "porsche" + "fiat");
		System.out.println(sb);
		System.out.println(sb.toString() + "BMW");
	}

	public static void streamTest18() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(x -> {

			int nombreO = 0;

			for (int j = 0; j < x.length(); j++) {

				if (x.charAt(j) == 'o') {
					nombreO++;
				}
			}
			return nombreO;

		}).forEach(x -> System.out.println(x));
	}

	public static void streamTest13() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.forEach(x -> System.out.println(x.substring(0, 2)));
	}

	public static void streamTest14() {
		Stream<String> s = Stream.of("mon111key", "gorill4a", "b7onobo");
		s.map(x -> {

			Pattern pattern = Pattern.compile("\\d+((,|\\.)\\d+)?");
			Matcher matcher = pattern.matcher(x);
			while (matcher.find()) {

				System.out.println(matcher.group(0));
			}
			return x;

		}).forEach(x -> System.out.print(""));

	}

	public static void streamTest16() {
		Stream<String> s = Stream.of("mon111key", "gorill4a", "b7onobo");
		s.map(x -> {

			Pattern pattern = Pattern.compile("\\d+((,|\\.)\\d+)?");
			Matcher matcher = pattern.matcher(x);
			while (matcher.find()) {
				String str = x.replace(matcher.group(0), "");
				System.out.println(str); // imprime
			}
			return x;

		}).forEach(x -> System.out.print("")); // imprime rien, juste terminal

	}

	public static void streamTest15() {
		Stream.of("mon111key", "gorill4a", "b7onobo").map(x -> {

			Pattern pattern = Pattern.compile("\\d+((,|\\.)\\d+)?");
			Matcher matcher = pattern.matcher(x);
			while (matcher.find()) {
				String str = x.replace(matcher.group(0), "");
				System.out.println(str);
			}
			return x;

		}).forEach(x -> System.out.print(""));

	}

	public static void streamTest20() {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
	}

	public static void streamTest19() {
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
	}

	public static void streamTest21() {
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);
	}

	public static void streamTest22() {
		Stream.of("a1", "a2", "a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println);
	}

	public static void streamTest23() {
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	public static void streamTest24() {
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});
	}

	private static void varTest() {

		StreamEx str = new StreamEx();
		System.out.println(str.a1);
		System.out.println(str.a2);
		System.out.println(str.b);
		System.out.println(str.c);
		System.out.println("Exists boolean: " + str.c);
		System.out.println(str.d);
		System.out.println("Exists Boolean: " + str.d);
		str.d = true;
		System.out.println(str.d);
	}

	public static void streamTest25() {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(4);
		myList.add(3);
		myList.add(5);

		myList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	public static void streamTest27() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bono");
		s.map(String::length).sorted().filter(x -> x % 2 == 0).forEach(x -> System.out.println((double) x / 2));
	}

	public static void streamTest26() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bono");
		s.map(String::length).sorted().skip(1).limit(2).forEach(x -> System.out.println((double) x / 2));
	}

	public static void streamTest29() {
		Stream<String> s = Stream.of("monkey", "monkeylllll", "gorilla", "bono");
		s.map(String::length).sorted().forEach(x -> System.out.println(x));
		s = Stream.of("monkey", "monkeylllll", "gorilla", "bono");
		System.out.println(s.collect(Collectors.toList()).get(2));
	}

	public static void streamTest30() {

		String name = "David";
		String age = "26";
		int age2 = 45;
		System.out.format("name=%s; age=%s; age2=%d", name, age, age2);
	}

	public static void streamTest31() {
		List<String> one = Arrays.asList("Peugeot", "renault");
		List<String> two = Arrays.asList("Mercedes", "Fiat");

		Stream<List<String>> voit3 = Stream.of(one, two);
		List<String> oneTwo = voit3.flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(oneTwo);
	}

	public static void streamTest32() {
		List<String> one = Arrays.asList("renault", "Peugeot", "renault", "Fiat", "Peugeot");

		one = one.stream().sorted().collect(Collectors.toList());
		System.out.println(one);

		Set<String> oneTwo2 = new HashSet<String>(one);
		oneTwo2 = oneTwo2.stream().sorted().collect(Collectors.toSet());
		System.out.println(oneTwo2);
	}

	public static void streamTest33() {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		System.out.println(stream.mapToInt(x -> x).sum());
	}

	public static void streamTest34() {
		List<String> one = Arrays.asList("Audi", "Mercedes");
		List<String> two = Arrays.asList("Skoda", "Ford", "Peugeot");
		int totalSize = one.size() + two.size();
		Stream<List<String>> t = Stream.of(one, two);
		t.flatMap(l -> l.stream()).map(String::length).sorted().skip(totalSize - 2).forEach(System.out::println);
	}

	/**
	 * pour test unitaire
	 * 
	 * @return
	 */
	public List<Integer> streamTest345() {
		List<String> one = Arrays.asList("Audi", "Mercedes");
		List<String> two = Arrays.asList("Skoda", "Ford", "Peugeot");
		int totalSize = one.size() + two.size();
		Stream<List<String>> t = Stream.of(one, two);
		return t.flatMap(l -> l.stream()).map(String::length).sorted().skip(totalSize - 2).collect(Collectors.toList());
	}

	public static void streamTest37() {
		List<String> one = Arrays.asList("Audi", "Mercedes");
		List<String> two = Arrays.asList("Skoda", "Ford", "Peugeot");
		Stream<List<String>> t = Stream.of(one, two);
		t.flatMap(l -> l.stream()).map(String::length).sorted(Comparator.reverseOrder()).limit(2)
				.forEach(System.out::println);
	}

	public static void streamTest42() {
		List<String> one = Arrays.asList("Audi", "Mercedes");
		List<String> two = Arrays.asList("Skoda", "Ford", "Peugeot");
		Stream<List<String>> t = Stream.of(one, two);
		boolean rep = t.flatMap(l -> l.stream()).map(String::length).anyMatch(x -> x % 2 == 1);
		System.out.println(rep);
	}

	public static void streamTest43() {
		List<String> one = Arrays.asList("Audi", "Mercedes");
		List<String> two = Arrays.asList("Skoda", "Ford", "Peugeot");
		Stream<List<String>> t = Stream.of(one, two);
		boolean rep = t.flatMap(l -> l.stream()).map(String::length)
				.peek(e -> System.out.println("Filtered value: " + e)).allMatch(x -> x % 2 == 0);
		System.out.println(rep);
	}

	public static void streamTest36() {
		String strTest = "100";
		int iTest = Integer.parseInt(strTest);
		System.out.println("Actual String:" + strTest);
		System.out.println("Converted to Int:" + iTest);
		// This will now show some arithmetic operation
		System.out.println("Arithmetic Operation on Int: " + (iTest / 4));
	}

	public static void streamTest38() {
		List<String> one = Arrays.asList("Renault", "Peugeot");
		boolean rep = one.stream().allMatch(x -> x.length() == 7);
		System.out.println(rep);
	}

	public static void streamTest39() {
		List<String> one = Arrays.asList("Renault", "Peugeot", "Fiat");
		boolean rep = one.stream().anyMatch(x -> x.length() == 7);
		System.out.println(rep);
	}

	public static void streamTest40() {
		List<String> one = Arrays.asList("Renault", "Peugeot", "Fiat");
		boolean rep = one.stream().noneMatch(x -> x.length() == 3);
		System.out.println(rep);
	}

	/**
	 * pour test unitaire
	 */
	public boolean streamTest401() {
		List<String> one = Arrays.asList("Renault", "Peugeot", "Fiat");
		return one.stream().noneMatch(x -> x.length() == 3);

	}

	/**
	 * 
	 * pour test unitaire
	 */
	public boolean streamTest4011(List<String> one) {

		return one.stream().noneMatch(x -> x.length() == 3);

	}

	public static void streamTest41() {
		List<String> one = Arrays.asList("Renault", "Peugeot");
		Predicate<String> pred = x -> x.length() == 7;
		boolean rep = one.stream().allMatch(pred);
		System.out.println(rep);
	}

	public static void streamTest45() {
		List<String> one = Arrays.asList("Renault", "Peugeot");
		long rep = one.stream().count();
		System.out.println(rep);
	}

	public static void streamTest46() {
		List<String> one = Arrays.asList("Renault", "Peugeot");
		one.stream().findAny().ifPresent(x -> System.out.println("found " + x));

	}

	public static void streamTest49() {
		List<String> one = Arrays.asList(null, "Renault", "Peugeot");
		List<String> two = one.stream().skip(1).collect(Collectors.toList());
		two.stream().findFirst().ifPresent(x -> System.out.println("found " + x));

	}

	public static void streamTest51() {
		Stream<String> s = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println);
		Stream<String> t = Stream.of("monkey", "ape", "bonobo");
		min = t.min((s1, s2) -> s2.length() - s1.length());
		min.ifPresent(System.out::println);
	}

	public static void streamTest48() {
		Stream<String> s = Stream.of("monkey", "zape", "bonobo");
		Optional<String> min = s.min(Comparator.naturalOrder());
		min.ifPresent(System.out::println);
	}

	public static void streamTest50() {
		Stream<Integer> s = Stream.of(6, 4, 2, 3);
		Optional<Integer> min = s.min(Comparator.naturalOrder());
		min.ifPresent(System.out::println);
	}

	public static void streamTest28() {
		List<Integer> one = Arrays.asList(3, 4, 5, 2, 9);
		Integer result = 0;

		for (Integer entier : one) {
//			result += entier.intValue();
			result = result + entier;
		}
		System.out.println(result);
	}

	public static void reduceMethod2() {
		List<Integer> one = Arrays.asList(3, 4, 5, 2, 9);
		System.out.println(one.stream().reduce(0, (a, b) -> a + b));
	}

	public static void reduceMethod3() {
		List<Integer> one = Arrays.asList(3, 4, 5, 2, 9);
		System.out.println(one.stream().reduce(1, (a, b) -> a * b));
	}

	public static void reduceMethod4() {
		List<String> one = Arrays.asList("Audi", "Renault", "Peugeot");
		System.out.println(one.stream().reduce("", (a, b) -> a.concat(b)));
	}

	public static void compterNombreDeMotsE() {

		List<String> list = new ArrayList<String>();
		list.add("subaru");
		list.add("renault");
		list.add("peugeotee");
		list.add("peugeo");
		list.stream().max(Comparator.comparing(mot -> nombreEATrouver(mot))).ifPresent(x -> System.out.println(x));
	}

	public int apply(String mot) {

		return nombreEATrouver(mot);
	}

	public static int nombreEATrouver(String mot) {
		int nombreE = 0;
		for (int i = 0; i < mot.length(); i++) {
			if (mot.charAt(i) == 'e') {
				nombreE++;
			}
		}
		return nombreE;
	}

	public boolean test(String s) {
		return s.contains("");
	}

	public static void streamTest55() {

		List<String> one = Arrays.asList("5", "1", "2");
		List<String> two = Arrays.asList("6", "3");

		Stream<List<String>> list = Stream.of(one, two);

		System.out.println(list.flatMap(l -> l.stream()).map(x -> Integer.parseInt(x)).reduce(0, (a, b) -> a + b));

	}

	/**
	 * pour test unitaire
	 */
	public Integer streamTest555() {

		List<String> one = Arrays.asList("5", "1", "2");
		List<String> two = Arrays.asList("6", "3");

		Stream<List<String>> list = Stream.of(one, two);

		return list.flatMap(l -> l.stream()).map(x -> Integer.parseInt(x)).reduce(0, (a, b) -> a + b);

	}

	/**
	 * pour test unitaire
	 */
	public Integer streamTest5552(List<String> one, List<String> two) {

		Stream<List<String>> list = Stream.of(one, two);

		return list.flatMap(l -> l.stream()).map(x -> Integer.parseInt(x)).reduce(0, (a, b) -> a + b);

	}

	public static void optionalTest() {

		Integer a = soustraction(2, 2);

		if (a == null) {
			System.out.println("Le résultat est nul");
		} else {
			System.out.println("" + a.intValue());
		}

	}

	public static void optionalTest2() {

		Optional<Integer> a = optionalSoustraction(2, 2);

		if (a.isPresent()) {
			System.out.println("" + a.get());
		} else {
			System.out.println("Le résultat est nul" + " " + a);
		}
		a.ifPresent(x -> System.out.println(x));
		System.out.println(a.orElse(-1));
		Optional<Integer> b = Optional.ofNullable(soustraction(3, 2));
		b.ifPresent(x -> System.out.println(x));
	}

	public static Integer soustraction(int a, int b) {

		int resultat = a - b;
		if (resultat == 0) {
			return null;
		}
		return resultat;
	}

	public static Optional<Integer> optionalSoustraction(int a, int b) {

		int resultat = a - b;
		if (resultat == 0) {
			return Optional.empty();
		}
		return Optional.of(resultat);
	}

	public static void notePlusFaible2() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		list.flatMap(l -> l.stream()).sorted(Comparator.comparing(x -> x.getNoteEtudiant())).limit(1)
				.forEach(x -> System.out.println(x.getName()));
	}

	public static void notePlusFaible3() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		list.flatMap(l -> l.stream()).sorted(Comparator.comparing(x -> x.getNoteEtudiant())).findFirst()
				.ifPresent(x -> System.out.println(x.getName()));

	}

	public static void notePlusFaible() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		list.flatMap(l -> l.stream()).max(Comparator.comparing(t -> t.getNoteEtudiant()))
				.ifPresent(x -> System.out.println(x.getName() + ";" + x.getNoteEtudiant()));

	}

	// pour test unitaire
	public Optional<Etudiant> notePlusHaute10() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		return list.flatMap(l -> l.stream()).max(Comparator.comparing(t -> t.getNoteEtudiant()));

	}

	public static void moyenneNoteClasse2() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		Double somme = list.flatMap(l -> l.stream()).map(Etudiant::getNoteEtudiant).reduce(0.0, (a, b) -> a + b);
		System.out.println(somme / (one.size() + two.size()));

	}

	public static void moyenneNoteClasse() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		Double somme = list.flatMap(l -> l.stream()).map(Etudiant::getNoteEtudiant).reduce(0.0, (a, b) -> a + b);
		long size = Stream.of(one, two).flatMap(r -> r.stream()).count();
		System.out.println(somme / size);

	}

	public static void noteFois5EtOnPrendNoteLaPlusFaible() {

		Stream<List<Etudiant>> list = Stream.of(one, two);

		list.flatMap(l -> l.stream()).min(Comparator.comparing(t -> t.getNoteEtudiant()))
				.ifPresent(r -> System.out.println(r.getName() + ":" + r.getNoteEtudiant() * 5));
	}

	public static void nomQuiPossedeMick(Stream<List<Etudiant>> list) {

		list.flatMap(l -> l.stream()).map(Etudiant::getName).filter(r -> r.contains("Mick"))
				.forEach(x -> System.out.println(x));
	}

	// pour test unitaire
	public List<String> nomQuiPossedeMick2(Stream<List<Etudiant>> list) {

		return list.flatMap(l -> l.stream()).map(Etudiant::getName).filter(r -> r.contains("Mick"))
				.collect(Collectors.toList());

	}

	public static void etudiantNoteSupEtInf50_2(Stream<List<Etudiant>> list) {
		List<Etudiant> liste2 = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 > 50)
				.forEach(t -> liste2.add(t));

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 < 50)
				.forEach(t -> liste2.add(t));

		liste2.forEach(x -> System.out.print(x.getName()));

	}

	public static void etudiantNoteSupEtInf50_3(Stream<List<Etudiant>> list) {
		List<String> liste2 = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 > 50)
				.forEach(t -> liste2.add(t.getName()));

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 < 50)
				.forEach(t -> liste2.add(t.getName()));

		System.out.println(liste2);

	}

	public static void etudiantNoteSupEtInf50_4(Stream<List<Etudiant>> list) {
		List<String> liste2 = new ArrayList<>();
		List<String> liste3 = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 > 50)
				.forEach(t -> liste2.add(t.getName() + " " + t.getNoteEtudiant()));

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 < 50)
				.forEach(t -> liste3.add(t.getName() + " " + t.getNoteEtudiant()));

		System.out.println(liste2 + ";" + liste3);

	}

	public static void etudiantNoteSupEtInf50_6(Stream<List<Etudiant>> list) {
		List<Etudiant> liste2 = new ArrayList<>();
		List<Etudiant> liste3 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 > 50)
				.collect(Collectors.toList());
		liste3 = Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 < 50)
				.collect(Collectors.toList());
		liste2.forEach(a -> System.out.println(a.getName() + " " + a.getNoteEtudiant()));
		liste3.forEach(a -> System.out.println(a.getName() + " " + a.getNoteEtudiant()));
	}

	/**
	 * pour test unitaire
	 * 
	 */
	public List<Etudiant> etudiantNoteSupEtInf50_7(Stream<List<Etudiant>> list) {

		return Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getNoteEtudiant() * 5 < 50)
				.collect(Collectors.toList());
	}

	public static void etudiantMickeyMoins5PointsNoteSupEtInf10() {
		List<Etudiant> liste2 = new ArrayList<>();
		List<Etudiant> liste3 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream())
				.map(etudiant -> {
					if (etudiant.getNoteEtudiant() == 13.1) { // etudiant vaut x comme lambda
						etudiant.setNoteEtudiant(etudiant.getNoteEtudiant() - 5);
					}
				return etudiant;
				})
				.filter(x -> x.getNoteEtudiant() > 10)
				.collect(Collectors.toList());
		
		liste3 = Stream.of(one, two).flatMap(l -> l.stream())
				.map(etudiant -> {
					if (etudiant.getNoteEtudiant() == 13.1) {
						etudiant.setNoteEtudiant(etudiant.getNoteEtudiant() - 5);
					}
				return etudiant;
				})
				.filter(x -> x.getNoteEtudiant() < 10)
				.collect(Collectors.toList());
		liste2.forEach(a -> System.out.println(a.getName() + " " + a.getNoteEtudiant()));
		liste3.forEach(a -> System.out.println(a.getName() + " " + a.getNoteEtudiant()));
	}

	public static void etudiantMickeySappelNowJess(Stream<List<Etudiant>> List) {

		List<Etudiant> liste2 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).map(etudiant -> {
			if (etudiant.getName().contains("Mickey")) { // etudiant vaut x comme lambda
				etudiant.setName("Jess");
			}
			return etudiant;
		}).collect(Collectors.toList());
		liste2.forEach(a -> System.out.println(a.getName() + " " + a.getNoteEtudiant()));
	}

	/**
	 * pour test unitaire
	 * 
	 */
	public List<Etudiant> etudiantMickeySappelNowJess2(Stream<List<Etudiant>> List) {

		return Stream.of(one, two).flatMap(l -> l.stream()).map(etudiant -> {
			if (etudiant.getName().contains("Mickey")) { // etudiant vaut x comme lambda
				etudiant.setName("Jess");
			}
			return etudiant;
		}).collect(Collectors.toList());

	}

	public static void moyenneNotePhystiqueAllEtudiant() {

		List<Matiere> liste2 = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).forEach((x -> {
			Optional<Matiere> opt = x.getMatiere().stream().filter(t -> t.getNom().equals("Physique")).findFirst();
			if (opt.isPresent()) {
				liste2.add(opt.get()); // opt.get est objet matiere de physique
			}
		}));

		Double somme = liste2.stream().map(x -> x.getNote()).reduce(0.0, (a, b) -> a + b);

		// long size= Stream. of (one, two).flatMap(r -> r.stream()).count();
		int size = liste2.size();
		System.out.println(somme / size);

	}

	public static void moyenneNotePhystiqueAllEtudiant2() {

		List<Matiere> liste2 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).flatMap(r -> r.getMatiere().stream())
				.filter(x -> x.getNom().equals("Physique")).collect(Collectors.toList());

		Double somme = liste2.stream().map(y -> y.getNote()).reduce(0.0, (a, b) -> a + b);
		int size = liste2.size();
		System.out.println(somme / size);
	}

	public static void moyenneNotePhystiqueAllEtudiant3() {

		List<Matiere> liste2 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).flatMap(r -> r.getMatiere().stream())
				.filter(x -> x.getNom().equals("Physique")).collect(Collectors.toList());

		Double moyenne = liste2.stream().mapToDouble(y -> y.getNote()).average().getAsDouble();
		System.out.println(moyenne);
	}

	public static void EtudiantNoteMathSup10() {

		Stream.of(one, two).flatMap(l -> l.stream()).forEach((x -> {
			Optional<Matiere> opt = x.getMatiere().stream().filter(t -> t.getNom().equals("Math")).findFirst();
			if (opt.isPresent() && opt.get().getNote() > 10) {
				System.out.println(x.getName());
			}
		}));

	}

	public static void AfficheEtudiantEtNoteMathSup10_2() {

		Stream.of(one, two).flatMap(l -> l.stream())
				.filter(x -> x.getMatiere().stream().filter(t -> t.getNom().equals("Math") && t.getNote() > 10)
						.findFirst().isPresent())
				.forEach(x -> System.out.println(" " + x.getName() + " "
						+ x.getMatiere().stream().filter(m -> m.getNom().equals("Math")).findFirst().get().getNote()));
	}

	/**
	 * pour test unitaire
	 */
	public List<Etudiant> AfficheEtudiantEtNoteMathSup10_23() {

		return Stream
				.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getMatiere().stream()
						.filter(t -> t.getNom().equals("Math") && t.getNote() > 10).findFirst().isPresent())
				.collect(Collectors.toList());
	}

	/**
	 * pour test unitaire
	 * 
	 */
	public List<Etudiant> AfficheEtudiantEtNoteMathSup10_232(List<Etudiant> one, List<Etudiant> two) {

		return Stream
				.of(one, two).flatMap(l -> l.stream()).filter(x -> x.getMatiere().stream()
						.filter(t -> t.getNom().equals("Math") && t.getNote() > 10).findFirst().isPresent())
				.collect(Collectors.toList());
	}

//      exemple
//		System.out.println(liste2); //retourne juste la ref
//		liste2.forEach(x->System.out.println(x.getNote()));

	public static void AfficheEtudiantMickeyEtNoteMathSup10() {

		Stream.of(one, two).flatMap(l -> l.stream())
				.filter(x -> x.getName().equals("Mickey") && x.getMatiere().stream()
						.filter(t -> t.getNom().equals("Math") && t.getNote() > 10).findFirst().isPresent())
				.forEach(x -> System.out.println(" " + x.getName() + " "
						+ x.getMatiere().stream().filter(m -> m.getNom().equals("Math")).findFirst().get().getNote()));
	}

	public static void moyenneDeToutesLesNotesMathsEtPhysique() {

		List<Matiere> MatierePhysique = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).forEach((x -> {
			Optional<Matiere> opt = x.getMatiere().stream().filter(t -> t.getNom().equals("Physique")).findFirst();
			if (opt.isPresent()) {
				MatierePhysique.add(opt.get()); // opt.get est objet matiere de physique
			}
		}));

		Double somme = MatierePhysique.stream().map(x -> x.getNote()).reduce(0.0, (a, b) -> a + b);

		int size = MatierePhysique.size();

		List<Matiere> matiereMaths = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).forEach((x -> {
			Optional<Matiere> opt = x.getMatiere().stream().filter(t -> t.getNom().equals("Math")).findFirst();
			if (opt.isPresent()) {
				matiereMaths.add(opt.get()); // opt.get est objet matiere de maths
			}
		}));

		Double somme2 = matiereMaths.stream().map(x -> x.getNote()).reduce(0.0, (a, b) -> a + b);

		Double Moyenne = (somme / size + somme2 / size) / 2;

		System.out.println(Moyenne);
	}

	public static void moyenneDeToutesLesNotesMathsEtPhysique2() {

		List<Matiere> matierePhysiqueEtMath = new ArrayList<>();

		Stream.of(one, two).flatMap(l -> l.stream()).forEach((x -> {
			Optional<Matiere> opt = x.getMatiere().stream().filter(t -> t.getNom().equals("Physique")).findFirst();
			if (opt.isPresent()) {
				matierePhysiqueEtMath.add(opt.get()); // opt.get est objet matiere de physique
			}
			opt = x.getMatiere().stream().filter(t -> t.getNom().equals("Math")).findFirst();
			if (opt.isPresent()) {
				matierePhysiqueEtMath.add(opt.get()); // opt.get est objet matiere de physique
			}
		}));

		System.out.println(matierePhysiqueEtMath.stream().map(x -> x.getNote()).reduce(0.0, (a, b) -> a + b)
				/ matierePhysiqueEtMath.size());
	}

	public static void moyenneDeToutesLesNotesMathsEtPhysique3() {
		List<Matiere> liste2 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).flatMap(r -> r.getMatiere().stream())
				.collect(Collectors.toList());

		Double somme = liste2.stream().map(y -> y.getNote()).reduce(0.0, (a, b) -> a + b);
		int size = liste2.size();
		System.out.println(somme / size);
	}

	public static void trierListeCroissant() {
		List<Integer> liste = Arrays.asList(5, 3, 7);

		int a;
		int i, j = 0;

		for (i = 0; i < liste.size(); i++) {
			for (j = i + 1; j < liste.size(); j++)

			{
				if (liste.get(j) < liste.get(i)) {
					a = liste.get(i);
					liste.set(i, liste.get(j));
					liste.set(j, a);
				}
			}
		}
		System.out.println("la liste triée est:" + liste);
	}

	public static void AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael() {

		Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> {
			if (x.getName().equals("Ranto") || x.getName().equals("Mickeal")) {
				return x.getMatiere() // isPresent return un optional. le retour est sur tout le if
						.stream().filter(t -> t.getNom().equals("Physique")).map(r -> {
							if (r.getNote() == 14 || r.getNote() == 12) {
								r.setNote(r.getNote() - 10);
							}
							return r;
						}).filter(u -> u.getNote() < 10).findFirst().isPresent();

			} else if (x.getMatiere().stream().filter(m -> m.getNom().equals("Physique") && m.getNote() < 10)
					.findFirst().isPresent()) {
				return true;
			} else {
				return false;
			}

		}).forEach(x -> System.out.println(x.getName()));
	}

	public static void AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael2() {

		Stream.of(one, two).flatMap(l -> l.stream())
			.map(e -> {
				Optional<Matiere> rantoMick = e.getMatiere().stream().filter(x -> x.getNom().equals("Physique")
				&& (e.getName().equals("Ranto") || e.getName().equals("Mickeal"))).findFirst();
					if (rantoMick.isPresent()) {
						Matiere matiere = rantoMick.get();
						matiere.setNote(matiere.getNote() - 10);
					}
				return e;
			})
			.filter(x -> x.getMatiere().stream().filter(s -> s.getNote() < 10)
			.findFirst().isPresent())
			.forEach(x -> System.out.println(x.getName()));
	}

	/**
	 * pour test unitaire
	 */
	public List<Etudiant> AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael22(
			List<Etudiant> one, List<Etudiant> two) {

		return Stream.of(one, two).flatMap(l -> l.stream())
				 .map(e -> {
					Optional<Matiere> rantoMick = e.getMatiere().stream().filter(x -> x.getNom().equals("Physique")
					&& (e.getName().equals("Ranto") || e.getName().equals("Mickeal"))).findFirst();	
						if (rantoMick.isPresent()) {
							Matiere matiere = rantoMick.get();
							matiere.setNote(matiere.getNote() - 10);			
						}
						return e;
				 })
				.filter(x -> x.getMatiere().stream().filter(s -> s.getNom().equals("Physique") && s.getNote() < 10)
				.findFirst().isPresent())
				.collect(Collectors.toList());
	}

	public void moyenneDeToutesLesNotesMathsEtPhysiqueSansCendrillion() {
		List<Matiere> liste2 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> !x.getName().equals("Cendrillon"))
				.flatMap(r -> r.getMatiere().stream()).collect(Collectors.toList());

		Double moyenne = liste2.stream().mapToDouble(y -> y.getNote()).average().getAsDouble();

//		System.out.println(moyenne);
		logger.error("moyenne");// commentaire de code
	}

	// Avec retour pour test unitaire
	public double moyenneDeToutesLesNotesMathsEtPhysiqueSansCendrillion2(List<Etudiant> one, List<Etudiant> two) {
		List<Matiere> liste2 = new ArrayList<>();

		liste2 = Stream.of(one, two).flatMap(l -> l.stream()).filter(x -> !x.getName().equals("Cendrillon"))
				.flatMap(r -> r.getMatiere().stream()).collect(Collectors.toList());

		Double moyenne = liste2.stream().mapToDouble(y -> y.getNote()).average().getAsDouble();

		System.out.println(moyenne);
		return moyenne;
	}

	public static void afficheMoyenneEtudiantSiSupMoyenneMathPhysique() {
		
		Stream<List<Etudiant>>stream=Stream.of(one,two);
		
	stream.flatMap(l -> l.stream())
		.map(x->{ 
			String message;
			double moyenneMathPhysEtudiant = x.getMatiere()
					.stream()
					.filter(c->c.getNom().equals("Physique")||c.getNom().equals("Math"))
					.mapToDouble(f->f.getNote())
					.average()
					.getAsDouble();
			
			if(x.getNoteEtudiant()!=null && x.getNoteEtudiant() >= moyenneMathPhysEtudiant) {
				message = x.getName() + " : General : " + x.getNoteEtudiant();
			}
			else {
				message= x.getName() + " : Moyenne de Maths et Physique : " + moyenneMathPhysEtudiant;
			}
			
			return message;
	
	}).forEach(k->System.out.println(k));
		
	}
	
	/**
	 * pour test unitaire
	 */
	public List<Double> afficheMoyenneEtudiantSiSupMoyenneMathPhysique2(List<Etudiant> one, List<Etudiant> two) {

		Stream<List<Etudiant>> stream = Stream.of(one, two);

		return stream.flatMap(l -> l.stream())
				.map(x -> {
					double note;
					double moyenneMathPhysEtudiant = x.getMatiere()
							.stream()
							.filter(c -> c.getNom().equals("Physique") || c.getNom().equals("Math"))
							.mapToDouble(f -> f.getNote())
							.average()
							.getAsDouble();

								if (x.getNoteEtudiant() != null && x.getNoteEtudiant() >= moyenneMathPhysEtudiant) {
									note = x.getNoteEtudiant();
								} else {
									note = moyenneMathPhysEtudiant;
								}
				return note;
				})
				.collect(Collectors.toList());
	}
	
	public static void afficherEtudiantQuiOnt1NoteInferieurA10() {
		
		Stream<List<Etudiant>> stream = Stream.of(one, two);
		
		stream.flatMap(l -> l.stream())
		
			.forEach(x -> {
				
				System.out.print(x.getName() + " ");
				
				if(x.getNoteEtudiant()!= null && x.getNoteEtudiant()<10) {
					System.out.print(x.getNoteEtudiant()+" ");
				} else {
					System.out.print("");
				}
				x.getMatiere().stream().filter(t -> t.getNote() < 10).forEach(y->System.out.print(y.getNote()+" "));
				System.out.print("\n");
		
		
			});
	}

}