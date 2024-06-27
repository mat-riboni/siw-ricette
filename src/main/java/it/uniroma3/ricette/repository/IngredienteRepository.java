package it.uniroma3.ricette.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.ricette.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

}
