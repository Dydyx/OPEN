package com.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.model.Etudiant;
@Repository
public interface IEtudiantRepo extends JpaRepository<Etudiant,Long>,EtudiantRepoCostum{

	//findBynom
	List <Etudiant>findByNom(String nom);
	List <Etudiant>findByPnom(String pnom);
	
}
