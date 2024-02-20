package com.example.restcountryfx.Services;

import com.example.restcountryfx.Models.CountryDTO;

import java.util.List;

public class RestCountriesService implements IRestCountries{
    @Override
    public String[] getRegions() {
        return new String[0];
    }

    @Override
    public List<CountryDTO> getCountriesByRegions(String region) {
        return null;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        return null;
    }
}
