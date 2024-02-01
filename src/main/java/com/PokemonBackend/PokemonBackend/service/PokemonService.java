package com.PokemonBackend.PokemonBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PokemonBackend.PokemonBackend.PokemonRepository;
import com.PokemonBackend.PokemonBackend.api.model.Pokemon;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemon(Integer id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    public boolean deletePokemon(Integer id) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            pokemonRepository.deleteById(id);
            return true; 
        } else {
            return false; 
        }
    }
}
