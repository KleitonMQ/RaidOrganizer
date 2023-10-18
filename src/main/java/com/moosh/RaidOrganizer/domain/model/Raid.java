package com.moosh.RaidOrganizer.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_raid")
public class Raid {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int star;

    @OneToOne(cascade = CascadeType.ALL)
    private Pokemon pokemon;
    
    private boolean megaRaid;
    private boolean done;
    private int doneTimes;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }
    public Pokemon getPokemon() {
        return pokemon;
    }
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public boolean isMegaRaid() {
        return megaRaid;
    }
    public void setMegaRaid(boolean megaRaid) {
        this.megaRaid = megaRaid;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public int getDoneTimes() {
        return doneTimes;
    }
    public void setDoneTimes(int doneTimes) {
        this.doneTimes = doneTimes;
    }    
}
