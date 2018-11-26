package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.model.Etudiant;
import com.formation.repository.IEtudiantRepo;

@Service
public class EtudiantService {
	@Autowired
	private IEtudiantRepo repository;
	
	public List<Etudiant> findAll() {
		return repository.findAll();
	}
	
	
	
	public Etudiant save(Etudiant etudiant) {
		return repository.saveAndFlush(etudiant);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
