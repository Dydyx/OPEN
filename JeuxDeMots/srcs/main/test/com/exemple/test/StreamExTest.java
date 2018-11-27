package com.exemple.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import stream.Etudiant;
import stream.Matiere;
import stream.StreamEx;
import stream.Voiture;

public class StreamExTest {
	
    StreamEx streamEx;

    private Etudiant etudiant1 = new Etudiant("Mathieu", 12.4, 16, 17);
	private Etudiant etudiant2 = new Etudiant("Mickeal", 16.3, 14, 8);
	private Etudiant etudiant3 = new Etudiant("Ranto", 10.0, 12, 6);

	private Etudiant etudiant4 = new Etudiant("Mickey", 13.1, 2, 12);
	private Etudiant etudiant5 = new Etudiant("Cendrillon", 8.9, 3, 7);
	
    
	private List<Etudiant> one = Arrays.asList(etudiant1, etudiant2, etudiant3);
	private List<Etudiant> two = Arrays.asList(etudiant4, etudiant5);

	
	
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
	
	Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
	
	@Before
	public void init() {
		streamEx=new StreamEx();
	}
	
	@Test
	public void test_moyenneDeToutesLesNotesMathsEtPhysiqueSansCendrillion2() {
		assertThat(10.875, equalTo(streamEx.moyenneDeToutesLesNotesMathsEtPhysiqueSansCendrillion2(one, two)));
	}
	
	@Test
	public void test_selectRouge3() {
		List<Voiture> liste = ajoutVoiture();
		List<Voiture> voituresRouge = streamEx.selectRouge3(liste);
		assertThat(voituresRouge.size(), equalTo(3));
		assertThat(voituresRouge.get(0).getMarque(), equalTo("Lamborgini"));
		assertThat(voituresRouge.get(1).getMarque(), equalTo("BMW"));
		assertThat(voituresRouge.get(2).getMarque(), equalTo("Porsche"));
	}
	
	@Test
	public void test_streamTest90() {
		
		assertThat(streamEx.streamTest90().size(), equalTo(1));
		
	}
	
	@Test
	public void test_notePlusHaute10() {
		
		assertTrue(streamEx.notePlusHaute10().isPresent());
		assertThat(streamEx.notePlusHaute10().get().getName(), equalTo("Mickeal"));
		assertThat(streamEx.notePlusHaute10().get().getNoteEtudiant(), equalTo(16.3));
	}
	
	@Test
	public void test_nomQuiPossedeMick2() {
		
		List<String> liste = streamEx.nomQuiPossedeMick2(Stream.of(one, two));
		assertThat(liste.size(), equalTo(2));
		assertThat(liste.get(0), equalTo("Mickeal"));
		assertThat(liste.get(1), equalTo("Mickey"));
	}
	
	@Test
	public void test_etudiantMickeySappelNowJess2() {
		List<Etudiant>liste=streamEx.etudiantMickeySappelNowJess2(Stream.of(one, two));
		assertThat(liste.get(3).getName(), equalTo("Jess"));
	}
	
	@Test
	public void test_etudiantNoteSupEtInf50_7() {
		List<Etudiant>liste=streamEx.etudiantNoteSupEtInf50_7(Stream.of(one, two));
		assertThat(liste.get(0).getName(), equalTo("Cendrillon"));
	}
	
	@Test
	public void test_streamTest345() {
		List<Integer>liste=streamEx.streamTest345();
		assertThat(liste.get(0), equalTo(7));
		assertThat(liste.get(1), equalTo(8));	
	}
	
	@Test
	public void test_streamTest401() {
		assertThat(streamEx.streamTest401(), equalTo(true));
	}
	
	@Test
	public void test_streamTest4011() {
	List<String> one = Arrays.asList("Fdf","Renault", "Peugeot", "Fiat");
	assertThat(streamEx.streamTest4011(one), equalTo(false));
	}
	
	@Test
	public void test_AfficheEtudiantEtNoteMathSup10_23() {
		List<Etudiant> liste = streamEx.AfficheEtudiantEtNoteMathSup10_23();
		assertThat(liste.size(), equalTo(2));
		assertThat(liste.get(0).getName(), equalTo("Mathieu"));
		assertThat(liste.get(1).getName(), equalTo("Mickey"));	
	}
	
	@Test
	public void test_AfficheEtudiantEtNoteMathSup10_232() {
		 Etudiant etudiant1 = new Etudiant("Mathieu", 12.4, 16, 17);
		 Etudiant etudiant2 = new Etudiant("Mickeal", 16.3, 14, 8);
		 Etudiant etudiant3 = new Etudiant("Ranto", 10.0, 12, 13);

		 Etudiant etudiant4 = new Etudiant("Mickey", 13.1, 2, 12);
		 Etudiant etudiant5 = new Etudiant("Cendrillon", 8.9, 3, 7);
		 Etudiant etudiant6 = new Etudiant("John", 6.7, 2, 4);
		 
		 List<Etudiant> one = Arrays.asList(etudiant1, etudiant2, etudiant3);
		 List<Etudiant> two = Arrays.asList(etudiant4, etudiant5, etudiant6);
		List<Etudiant> liste = streamEx.AfficheEtudiantEtNoteMathSup10_232(one, two);
		assertThat(liste.size(), equalTo(3));
		assertThat(liste.get(0).getName(), equalTo("Mathieu"));
		assertThat(liste.get(1).getName(), equalTo("Ranto"));
		assertThat(liste.get(2).getName(), equalTo("Mickey"));	
	}
	
	
	@Test
	public void test_streamTest555() {
		assertThat(streamEx.streamTest555(), equalTo(17));
	
	}
	
	@Test
	public void test_streamTest5552() {
	List<String> one = Arrays.asList("5", "1", "2");
	List<String> two = Arrays.asList("6", "3", "4");
	assertThat(streamEx.streamTest5552(one,two), equalTo(21));
	}
	
	@Test
	public void test_streamTest5553() {
	List<String> one = Arrays.asList();
	List<String> two = Arrays.asList();
	assertThat(streamEx.streamTest5552(one,two), equalTo(0));
	}
	
	@Test
	public void test_AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael22() {
		List<Etudiant> liste = streamEx.AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael22(one, two);
		assertThat(liste.size(),equalTo(4));
		assertThat(liste.get(0).getName(), equalTo("Mickeal"));
		assertThat(liste.get(1).getName(), equalTo("Ranto"));
		assertThat(liste.get(2).getName(), equalTo("Mickey"));
		assertThat(liste.get(3).getName(), equalTo("Cendrillon"));
	}
	
	@Test
	public void test_AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael223() {
		 Etudiant etudiant6 = new Etudiant("John", 6.7, 10, 8);
		 List<Etudiant> three = Arrays.asList(etudiant4, etudiant5, etudiant6);
		
		List<Etudiant> liste = streamEx.AfficherEtudiantQuiNontPasEuMoyenneEnPhysiqueEtMoins10PointsSurNoteRantoEtMickael22(one, three);
		assertThat(liste.size(),equalTo(4));
		assertThat(liste.get(0).getName(), equalTo("Mickeal"));
		assertThat(liste.get(1).getName(), equalTo("Ranto"));
		assertThat(liste.get(2).getName(), equalTo("Mickey"));
		assertThat(liste.get(3).getName(), equalTo("Cendrillon"));
	}
	
	@Test
	public void test_afficheMoyenneEtudiantSiSupMoyenneMathPhysique2() {
		Etudiant etudiant6 = new Etudiant("Santa", null, 12, 6);
		List<Etudiant> three = Arrays.asList(etudiant4, etudiant5, etudiant6); 
		List<Double> liste = streamEx.afficheMoyenneEtudiantSiSupMoyenneMathPhysique2(one, three);
		assertThat(liste.size(), equalTo(6));
		assertThat(liste.get(0), equalTo(16.5));
		assertThat(liste.get(1), equalTo(16.3));
		assertThat(liste.get(2), equalTo(10.0));
		assertThat(liste.get(3), equalTo(13.1));
		assertThat(liste.get(4), equalTo(8.9));
		assertThat(liste.get(5), equalTo(9.0));
	}
}
