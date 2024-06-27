package it.uniroma3.ricette.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.ricette.model.Ricetta;

public interface RicettaRepository extends CrudRepository<Ricetta, Long> {

}
