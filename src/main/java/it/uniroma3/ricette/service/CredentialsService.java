package it.uniroma3.ricette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.ricette.model.Credentials;
import it.uniroma3.ricette.repository.CredentialsRepository;

@Service
public class CredentialsService {

	@Autowired
	CredentialsRepository repository;
	
	public Credentials getCredentialsById(Long id) {
		return repository.findById(id).get();
	}
	
	public Credentials getCredentialsByUsername(String username) {
		return repository.findByUsername(username).get();
	}
	
	public Credentials save(Credentials credentials) {
		return repository.save(credentials);
	}
	
	public boolean existsByUsername(String username) {
		return repository.existsByUsername(username);
	}
	

}
