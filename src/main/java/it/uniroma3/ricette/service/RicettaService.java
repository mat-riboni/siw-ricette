package it.uniroma3.ricette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.ricette.repository.RicettaRepository;

@Service
public class RicettaService {
	
	@Autowired
	RicettaRepository repository;
}
