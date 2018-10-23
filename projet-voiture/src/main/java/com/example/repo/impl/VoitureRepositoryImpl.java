package com.example.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Voiture;
import com.example.repo.VoitureRepositoryCustom;
@Repository
public class VoitureRepositoryImpl implements VoitureRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;


	@Override
	public List<Voiture> searchPrixLessThan(int prix) {


Query query = entityManager.createNativeQuery("SELECT * FROM voiture WHERE prix <= ?", Voiture.class);
query.setParameter(1, prix);
		return query.getResultList();
	}

}
