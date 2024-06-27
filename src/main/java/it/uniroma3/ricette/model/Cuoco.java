package it.uniroma3.ricette.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cuoco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotBlank
	@NotNull
	@NotEmpty
	private String cognome;
	
	@NotBlank
	@NotNull
	@NotEmpty
	private String email;
	
	//Foto
	
	@OneToMany
	@JoinColumn(name = "cuoco_id")
	private List<Ricetta> ricetteScritte;
	
	@OneToMany
	private List<Ricetta> ricetteSalvate;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public List<Ricetta> getRicetteScritte() {
		return ricetteScritte;
	}

	public void setRicetteScritte(List<Ricetta> ricetteScritte) {
		this.ricetteScritte = ricetteScritte;
	}

	public List<Ricetta> getRicetteSalvate() {
		return ricetteSalvate;
	}

	public void setRicetteSalvate(List<Ricetta> ricetteSalvate) {
		this.ricetteSalvate = ricetteSalvate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuoco other = (Cuoco) obj;
		return Objects.equals(email, other.email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
