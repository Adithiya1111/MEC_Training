package com.example;

public class Pokemon {
    private int id;
    private String name;
    private String rarity;

    public Pokemon() {}
    public Pokemon(int id, String name, String rarity) {
        this.id = id; this.name = name; this.rarity = rarity;
    }
    public Pokemon(String name, String rarity) {
        this.name = name; this.rarity = rarity;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
}