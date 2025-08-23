package com.example.pokemon.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pokemon.modal.Pokemon;


public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon>findByRarityContaining(String rarity);

    List<Pokemon> findByCategoryContaining(String category);

    List<Pokemon> findByRegionContaining(String region);

   // List<Pokemon> deleteByRarityContaining(String rarity);
    
} 