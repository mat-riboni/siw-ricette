package it.uniroma3.ricette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.ricette.repository.RecensioneRepository;

@Service
public class RecensioneService {

	@Autowired
	RecensioneRepository repository;
	
}
