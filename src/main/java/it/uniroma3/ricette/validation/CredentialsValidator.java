package it.uniroma3.ricette.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import it.uniroma3.ricette.model.Credentials;
import it.uniroma3.ricette.service.CredentialsService;
import org.springframework.validation.Validator;

@Component
public class CredentialsValidator implements Validator{

	@Autowired
	CredentialsService service;
	
	@Override
	public void validate(Object o, Errors errors) {
		Credentials credentials = (Credentials) o;
		if(credentials.getUsername() != null && 
				service.existsByUsername(credentials.getUsername())) {
			errors.reject("credentials.duplicate");
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Credentials.class.equals(aClass);
	}

	
	
}
