/**
 * 
 */
package com.example.controller;

import java.util.List;

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
import com.example.service.impl.CalculImpl;
import com.example.service.impl.CalculImpl2;
import com.example.service.impl.CalculImpl3;


/**
 * 
 *
 */
@Controller
public class WebController {
	
	@Autowired
	VoitureRepository repository;
	
	@Autowired
	CalculImpl calculService;
	
	@Autowired
	CalculImpl2 calculService2;
	
	@Autowired
	CalculImpl3 calculService3;
	
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
	
	@RequestMapping("/searchmarquewithshortname")
	public String fetchDatasearchMarqueWithShortName(@RequestParam("marque") String marque, Model model){
		String result = "";
		
		for(Voiture cust: repository.searchMarqueWithShortName(marque)){
			result += cust.toString() + "<br>"; 
		}
		
		model.addAttribute("result", result);
		
		return "find";
	}
	
	@RequestMapping("/findall")
	public String findAll(Model model){
		String result = "";
		
		for(Voiture cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}
		model.addAttribute("result", result);
		
		return "find";
	}
	
	@RequestMapping("/calculMoyenne")
	public String calculMoyenne(Model model){
		
		double moyenne = calculService.calculMoyenne();
		
		model.addAttribute("moyenne", moyenne);
		
		return "moyenne";
	}
	
	@RequestMapping("/deuxRecentes")
	public String calculDeuxPlusRecentes(Model model){
		
		List<Voiture> deuxRecentes = calculService2.deuxRecentes();
		
		String result = "";
		
		for(Voiture cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}
		
		model.addAttribute("deuxRecentes", deuxRecentes);
		
		return "deuxRecentes";
	}
	
	@RequestMapping("/deuxAnciennes")
	public String calculDeuxPlusAnciennes(Model model){
		
		List<Voiture> deuxAnciennes = calculService3.deuxAnciennes();
		
		String result = "";
		
		for(Voiture cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}
		
		model.addAttribute("deuxAnciennes", deuxAnciennes);
		
		return "deuxAnciennes";
	}
	
}

