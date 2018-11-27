package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Voiture;
import com.example.repo.VoitureRepository;
import com.example.service.CalculInterface;

@Component
public class CalculImpl implements CalculInterface{
	
	@Autowired
	VoitureRepository repository;
	
	public double calculMoyenne() {
		List<Voiture> voitures = repository.findAll();
		
		double total=0;
		
		for(Voiture voiture : voitures) 
		{
			 total += voiture.getPrix();
			
		}
		double moyenne = total / voitures.size();
		System.out.println(moyenne);
		
		
		return moyenne;
	}
	


}
