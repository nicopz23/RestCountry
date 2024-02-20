package com.example.restcountryfx.Models;

import javafx.scene.image.Image;

public class CountryDTO {
    private String name;
    private String flag;
    private String region;
    private String capital;
    private String coin;
    private int population;

    public CountryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                ", region='" + region + '\'' +
                ", capital='" + capital + '\'' +
                ", coin='" + coin + '\'' +
                ", population=" + population +
                '}';
    }
}
