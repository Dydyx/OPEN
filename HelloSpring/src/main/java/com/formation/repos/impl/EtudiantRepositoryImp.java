package com.formation.repos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.formation.model.Etudiant;
import com.formation.repository.EtudiantRepoCostum;
@Repository
public class EtudiantRepositoryImp implements EtudiantRepoCostum {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Etudiant> noteLessThan(Double note) {


Query query = entityManager.createNativeQuery("SELECT * FROM etudiant WHERE note <= ?", Etudiant.class);
query.setParameter(1, note);
		return query.getResultList();
	}

	
}
