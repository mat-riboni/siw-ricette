package it.uniroma3.ricette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.ricette.model.Credentials;
import it.uniroma3.ricette.model.Cuoco;
import it.uniroma3.ricette.service.CredentialsService;
import it.uniroma3.ricette.validation.CredentialsValidator;
import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	CredentialsService credentialsService;
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired 
	CredentialsValidator credentialsValidator;
	
	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		model.addAttribute("utente", new Cuoco());
		model.addAttribute("credentials",new Credentials());
		return "registrationForm.html";
	}
	
	@PostMapping("/register")
	public String registerNewUser(
			@Valid @ModelAttribute("utente") Cuoco utente,
			BindingResult utenteBindingResult,
			@Valid @ModelAttribute("credentials") Credentials credentials,
			BindingResult bindingResult) {
		this.credentialsValidator.validate(credentials, bindingResult);
		if(!bindingResult.hasErrors()) {
			credentials.setCuoco(utente);
			credentials.setPassword(encoder.encode(credentials.getPassword()));
			credentials.setRole(Credentials.USER_ROLE);
			credentialsService.save(credentials);
			
			return "redirect:/login";
		} else {
			return "registrationForm.html";
		}
		
	}
	
	@GetMapping("/login")
	public String getLoginForm(Model model) {
		return "loginForm.html";
	}
	
	
	@GetMapping("/")
	public String getIndex() {
		return "index.html";
	}
	
}
