/**
 * 
 */
package com.example.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Voiture;
import com.example.repo.VoitureRepository;

/**
 * 
 *
 */
@Controller
public class WebController {
	
	@Autowired
	VoitureRepository repository;
	
	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/form", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("voiture", new Voiture("", "", 0, 0));
        return "form";
    }
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Voiture voiture, Model model) {
         
        model.addAttribute("voiture", voiture);
        String info = String.format("Customer Submission: marque = %s, modele = %s, annee = %s, prix = %s", voiture.getMarque(), voiture.getModele(), voiture.getAnnee(), voiture.getPrix());
        log.info(info);
        
        // save a single Person
 		repository.save(voiture);
         
        return "add";
    }
	
	@RequestMapping("/findbymarque")
	public String fetchDataByMarque(@RequestParam("marque") String marque, Model model){
		String result = "";
		
		for(Voiture cust: repository.findByMarque(marque)){
			result += cust.toString() + "<br>"; 
		}
		
		model.addAttribute("result", result);
		
		return "find";
	}
	
	@RequestMapping("/findbyprix")
	public String fetchDataByPrix(@RequestParam("prix") int prix, Model model){
		String result = "";
		
		for(Voiture cust: repository.findByPrix(prix)){
			result += cust.toString() + "<br>"; 
		}
		
		model.addAttribute("result", result);
		
		return "find";
	}
	
	@RequestMapping("/findbyprixlessthan")
	public String fetchDataByPrixLessThan(@RequestParam("prix") int prix, Model model){
		String result = "";
		
		for(Voiture cust: repository.searchPrixLessThan(prix)){
			result += cust.toString() + "<br>"; 
		}
		
		model.addAttribute("result", result);
		
		return "find";
	}
}
