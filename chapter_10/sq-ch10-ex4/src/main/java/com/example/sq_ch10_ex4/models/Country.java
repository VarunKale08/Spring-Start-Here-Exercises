package com.example.sq_ch10_ex4.models;

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


    public static Country of(String username, int population){
        Country c = new Country();

        c.setName(username);
        c.setPopulation(population);

        return c;
    }

}
