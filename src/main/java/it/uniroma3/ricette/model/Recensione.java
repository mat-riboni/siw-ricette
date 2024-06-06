package it.uniroma3.ricette.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recensione {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int valutazione;
	
	
	@ManyToOne
	@JoinColumn(name = "autore_id")
	private Cuoco autore;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getValutazione() {
		return valutazione;
	}


	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}


	public Cuoco getAutore() {
		return autore;
	}


	public void setAutore(Cuoco autore) {
		this.autore = autore;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		return id == other.id;
	}
	
	
	
	
}
