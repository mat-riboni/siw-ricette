package it.uniroma3.ricette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.uniroma3.ricette.service.IngredienteService;

@Controller
public class IngredienteController {

	@Autowired
	IngredienteService service;
}
