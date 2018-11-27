package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Voiture;
import com.example.repo.VoitureRepository;

import com.example.service.CalculInterface3;

@Component
public class CalculImpl3 implements CalculInterface3 {

	@Autowired
	VoitureRepository repository;

	public List<Voiture> deuxAnciennes() {
		List<Voiture> voitures = repository.findAll();
		// tri croissant
		for (int i = 0; i < voitures.size(); i++) {
			for (int j = i + 1; j < voitures.size(); j++)
			{
				Voiture voiture1 = voitures.get(i);
				Voiture voiture2 = voitures.get(j);
				if (voiture2.getAnnee() < (voiture1.getAnnee())) {
					voitures.set(i, voiture2);
					voitures.set(j, voiture1);
				}
			}
		}
		return voitures.subList(0, 2);
	}
}