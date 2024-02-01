package com.PokemonBackend.PokemonBackend;

import org.springframework.data.repository.CrudRepository;

import com.PokemonBackend.PokemonBackend.api.model.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer>{
    
}
