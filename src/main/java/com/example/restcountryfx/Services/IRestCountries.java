package com.example.restcountryfx.Services;

import com.example.restcountryfx.Models.CountryDTO;

import java.util.List;

public interface IRestCountries {
    public String[] getRegions();
    public List<CountryDTO> getCountriesByRegions(String region);
    public CountryDTO getCountryByName(String name);
}
