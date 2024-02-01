package com.PokemonBackend.PokemonBackend.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PokemonBackend.PokemonBackend.api.model.Pokemon;
import com.PokemonBackend.PokemonBackend.service.PokemonService;

@RestController //Kommer automatiskt formatera om detta och skapa ett json-objekt
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    
    @GetMapping("pokemon")
    public Pokemon getPokemon(@RequestParam Integer id) {
        return pokemonService.getPokemon(id);
    }

    @GetMapping("/pokemons")
    public List<Pokemon> getPokemons() {
        return pokemonService.getPokemons();
    }
    
    
    @PostMapping("/pokemon") //Plocka in vad nya pokemon ska sparas
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        System.out.println("Ny pokemon skapad " + pokemon);
        return pokemonService.createPokemon(pokemon);
    }

      @DeleteMapping("/pokemon/{id}")
        public String deletePokemon(@PathVariable Integer id) {
        if (pokemonService.deletePokemon(id)) {
            return "Pokemon with ID " + id + " deleted successfully.";
        } else {
            return "Pokemon with ID " + id + " not found.";
        }
    }
}
