package com.example.pokemon.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "pokelist")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "category")
    private String category;

    @Column(name = "region")
    private String region;

    @Column(name = "strongestAttack")
    private String strongestAttack;

    @Column(name = "evolution")
    private String evolution;

    public Pokemon() {

    }

    public Pokemon(String name, String rarity, String category, String region, String strongestAttack, String evolution) {
        this.name = name;
        this.rarity = rarity;
        this.category = category;
        this.region = region;
        this.strongestAttack = strongestAttack;
        this.evolution = evolution;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStrongestAttack(){
        return strongestAttack;
    }

    public void setStrongestAttack(String strongestAttack){
        this.strongestAttack = strongestAttack;
    }
    
    public String getEvolution(){
        return evolution;
    }

    public void setEvolution(String evolution){
        this.evolution = evolution;
    }


    // @Override
    // public String toString() {
    //     return "Pokemon [id=" + id + ", name=" + name + ", desc=" + rarity + ", category=" + category + "]";
    // }
}