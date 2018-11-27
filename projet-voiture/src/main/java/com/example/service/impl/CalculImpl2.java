package com.example.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Voiture;
import com.example.repo.VoitureRepository;

import com.example.service.CalculInterface2;

@Component
public class CalculImpl2 implements CalculInterface2{
	
	@Autowired
	VoitureRepository repository;
	

	public List<Voiture> deuxRecentes() {
		List<Voiture> voitures = repository.findAll();
		//tri décroissant	
		Voiture a;
		int i, j = 0;

		for ( i=0;i<voitures.size();i++)
        {
            for (j=i+1;j<voitures.size();j++)

            {
                   if (Double.valueOf(voitures.get(j).getAnnee())>(Double.valueOf(voitures.get(i).getAnnee())))
                       {
                            a= voitures.get(i);
                            voitures.set(i, voitures.get(j));
                            voitures.set(j, a);
                       }
            }
        }
		System.out.println("les 2 voitures les plus récentes sont: ");
		
		return voitures.subList(0, 2);    
	}
	
}

	

	
	



