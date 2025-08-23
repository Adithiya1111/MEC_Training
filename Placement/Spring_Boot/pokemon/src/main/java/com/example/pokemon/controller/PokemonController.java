package com.example.pokemon.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.pokemon.modal.Pokemon;
import com.example.pokemon.repository.PokemonRepository;

@RestController
@RequestMapping("/api")

public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    // CRUD OPERATIONS

    // 1. Display

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemons() {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();

            pokemonRepository.findAll().forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2. Display by Id

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") long id) {
        Optional<Pokemon> pokemonData = pokemonRepository.findById(id);

        if (pokemonData.isPresent()) {
            return new ResponseEntity<>(pokemonData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 3. Insert

    @PostMapping("/pokemon")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        try {
            Pokemon s1 = new Pokemon(pokemon.getName(), pokemon.getRarity(), pokemon.getCategory(), pokemon.getRegion(),
                    pokemon.getStrongestAttack(), pokemon.getEvolution());

            Pokemon _pokemon = pokemonRepository.save(s1);

            return new ResponseEntity<>(_pokemon, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 4. Update by id

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> updateStudent(@PathVariable("id") long id, @RequestBody Pokemon pokemon) {
        Optional<Pokemon> pokemonData = pokemonRepository.findById(id);

        if (pokemonData.isPresent()) {
            Pokemon _pokemon = pokemonData.get();
            _pokemon.setName(pokemon.getName());
            _pokemon.setRarity(pokemon.getRarity());
            _pokemon.setCategory(pokemon.getCategory());
            _pokemon.setRegion(pokemon.getRegion());
            _pokemon.setStrongestAttack(pokemon.getStrongestAttack());
            _pokemon.setEvolution(pokemon.getEvolution());
            return new ResponseEntity<>(pokemonRepository.save(_pokemon), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Delete by id

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<HttpStatus> deletePokemon(@PathVariable("id") long id) {
        try {
            pokemonRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 6. Delete All

    @DeleteMapping("/pokemon")
    public ResponseEntity<HttpStatus> deleteAllPokemon() {
        try {
            pokemonRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 7. Get by Rarity

    @GetMapping("/pokemon/rarity")
    public ResponseEntity<List<Pokemon>> getAllPokemonByRarity(@RequestParam(required = true) String rarity) {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();

            pokemonRepository.findByRarityContaining(rarity).forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 8. Get by region

    @GetMapping("/pokemon/category")
    public ResponseEntity<List<Pokemon>> getAllPokemonBycategory(@RequestParam(required = true) String category) {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();

            pokemonRepository.findByCategoryContaining(category).forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 9. Get by region

    @GetMapping("/pokemon/region")
    public ResponseEntity<List<Pokemon>> getAllPokemonByRegion(@RequestParam(required = true) String region) {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();

            pokemonRepository.findByRegionContaining(region).forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 10. Total Count

    @GetMapping("/pokemon/count")
    public ResponseEntity<Long> count() {
        try {
            long count = pokemonRepository.count();
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
