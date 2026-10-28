package com.example.sq_ch10_ex3.models;

public class Country {

    private String name;
    private int population;


    public void setName(String name){
        this.name = name;
    }


    public void setPopulation(int population){
        this.population = population;
    }


    public String getName(){
        return this.name;
    }

    public int getPopulation(){
        return this.population;
    }


    public static Country of(String name, int population){
        Country c = new Country();
        c.setName(name);
        c.setPopulation(population);
        return c;
    }
}
