package com.formation.contoller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.formation.model.Etudiant;
import com.formation.repository.IEtudiantRepo;
import com.formation.service.EtudiantService;

@Controller
public class HelloController {
	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IEtudiantRepo etudiantrep;

	private EtudiantService service;

	@RequestMapping(value = { "/hello" }, method = RequestMethod.GET)
	public String hello() {
		log.info("COUCOU");
		return "hello";
	}

	@RequestMapping(value = { "/listeEtudiants" }, method = RequestMethod.GET)
	public String listeEtudiants(Model model) {
		model.addAttribute("etudiant", etudiantrep.findAll());
		return "listeEtudiants";
	}

	@RequestMapping(value = "/ajouter", method = RequestMethod.GET)
	public String pageSuivante(@ModelAttribute Etudiant etudiant, Model model) {
		String info = String.format(" cc");
		log.info(info);

		return "ajouter";
	}

	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public String EtudiantSubmit(@ModelAttribute Etudiant etudiant, Model model) {

		model.addAttribute("etudiant", etudiant);
		String info = String.format(" nom = %s, pnom = %s, age = %s, note = %s", etudiant.getNom(), etudiant.getPnom(),
				etudiant.getAge(), etudiant.getNote());
		log.info(info);
		etudiantrep.save(etudiant);

		return "ajouter";
	}

	@GetMapping("/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/etudiant");
		mv.addObject("etudiant", service.findAll());

		return mv;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		Etudiant etudiant = etudiantrep.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		etudiantrep.delete(etudiant);
		model.addAttribute("etudiant", etudiantrep.findAll());
		return "listeEtudiants";
	}

	@GetMapping("/modifier/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Etudiant etudiant = etudiantrep.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("etudiant", etudiant);
		return "modifier";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") long id, @ModelAttribute Etudiant etudiant, Model model) {
		log.info("**id" + id);
		model.addAttribute("etudiant", etudiant);
		etudiant.setIdetudiant(id);
		log.info("**etudiant" + etudiant.getIdetudiant());
		etudiantrep.save(etudiant);
		return "hello";
	}

	@RequestMapping("/findBy")
	public String chercher(@RequestParam("nom") String nom, @RequestParam("pnom") String pnom,
			@RequestParam("note") Double note, Model model) {

		log.info("**bynom" + nom);
		log.info("**bypnom" + pnom);
		log.info("**bynote" + note);
		if (!nom.isEmpty())
			model.addAttribute("etudiant", etudiantrep.findByNom(nom));
		else if (!pnom.isEmpty())
			model.addAttribute("etudiant", etudiantrep.findByPnom(pnom));
		else
			model.addAttribute("etudiant", etudiantrep.findAll());
		if (note != null)
			model.addAttribute("etudiant", etudiantrep.noteLessThan(note));
		return "listeEtudiants";
	}
}
