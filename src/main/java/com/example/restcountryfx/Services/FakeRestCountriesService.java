package com.example.restcountryfx.Services;

import com.example.restcountryfx.Models.CountryDTO;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class FakeRestCountriesService implements IRestCountries{
    @Override
    public String[] getRegions() {
        return new String[]{"Europe","Asia","America","Oceania","Africa","Antartida"};
    }

    @Override
    public List<CountryDTO> getCountriesByRegions(String region) {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        CountryDTO countryDTO = new CountryDTO();
        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO.setName("Spain");
        countryDTO1.setName("Colombia");
        countryDTOList.add(countryDTO);
        countryDTOList.add(countryDTO1);
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName("Spain");
        countryDTO.setCapital("Madrid");
        countryDTO.setCoin("Euro");
        countryDTO.setPopulation(38000000);
        countryDTO.setRegion("Europa");
        countryDTO.setFlag("https://flagcdn.com/w320/es.png");
        return countryDTO;
    }
}
