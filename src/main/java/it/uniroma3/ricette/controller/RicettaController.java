package it.uniroma3.ricette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.ricette.model.Ricetta;
import it.uniroma3.ricette.service.RicettaService;

@Controller
public class RicettaController {

	@Autowired
	RicettaService service;
	
	@GetMapping("/creaRicetta")
	public String creaRicetta(Model model) {
		model.addAttribute("ricetta", new Ricetta());
		model.addAttribute("ingredienti", new String());
		return "nuovaRicettaForm.html";
	}
}
