package com.moosh.RaidOrganizer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "tb_pokemon")
public class Pokemon {
    
    @Id
    private int dexNumber;
    
    private String pokemonName;
    
    private String pokemonPNG;


    public int getDexNumber() {
        return dexNumber;
    }
    public void setDexNumber(int dexNumber) {
        this.dexNumber = dexNumber;
    }
    public String getPokemonName() {
        return pokemonName;
    }
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
    public String getPokemonPNG() {
        return pokemonPNG;
    }
    public void setPokemonPNG(String pokemonPNG) {
        this.pokemonPNG = pokemonPNG;
    }


}
