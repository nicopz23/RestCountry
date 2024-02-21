package com.example.restcountryfx.Models;

public class CountryDTO {
    private String name;
    private String flag;
    private String region;
    private String capital;
    private String coin;
    private int population;
    private String cca3;

    public static CountryDTO from(CountryDAO countryDAO){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(countryDAO.name.common);
        String capital = "";
        if (countryDAO.capital!=null)
            if (countryDAO.capital.length>0)
                capital= countryDAO.capital[0];
        countryDTO.setCapital(capital);
        countryDTO.setFlag(countryDAO.flags.png);
        countryDTO.setPopulation(countryDAO.population);
        countryDTO.setRegion(countryDAO.region);
        String coin = "";
        if (countryDAO.currencies!=null) {
            String keyCurrecy = (String) countryDAO.currencies.keySet().toArray()[0];
            coin = countryDAO.currencies.get(keyCurrecy).name;
        }
        countryDTO.setCoin(coin);
        countryDTO.setCca3(countryDAO.cca3);
        return countryDTO;
    }

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

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
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
