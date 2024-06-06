package it.uniroma3.ricette.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cuoco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String cognome;
	private String username;
	
	//Foto
	
	@OneToMany(mappedBy = "autore")
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return Objects.hash(username);
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
		return Objects.equals(username, other.username);
	}
	
	
	
}
