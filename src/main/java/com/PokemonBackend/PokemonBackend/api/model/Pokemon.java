package com.PokemonBackend.PokemonBackend.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
    @Id
    private int id;
    private String name;
    private String picURL;

    public Pokemon() {
        
    }
    
    public Pokemon(int id, String name, String picURL) {
        this.id = id;
        this.name = name;
        this.picURL = picURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    
}
