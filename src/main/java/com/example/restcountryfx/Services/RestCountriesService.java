package com.example.restcountryfx.Services;

import com.example.restcountryfx.Models.CountryDAO;
import com.example.restcountryfx.Models.CountryDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class RestCountriesService implements IRestCountries{
    @Override
    public String[] getRegions() {
        List<String> regions = new ArrayList<>();
        String url = "https://restcountries.com/v3.1/all";
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            CountryDAO[] object = gson.fromJson(datos, CountryDAO[].class);
            for (CountryDAO countryDAO:object){
                if (! regions.contains(countryDAO.region)){
                    regions.add(countryDAO.region);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] regionsArray = new String[regions.size()];
        for (int i = 0; i < regions.size(); i++) {
            regionsArray[i] = regions.get(i);
        }
        return regionsArray;
    }

    @Override
    public List<CountryDTO> getCountriesByRegions(String region) {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        String url ="https://restcountries.com/v3.1/region/"+region;
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            List<CountryDAO> object = gson.fromJson(datos,new TypeToken<List<CountryDAO>>(){}.getType());
            for (CountryDAO countryDAO:object){
                countryDTOList.add(CountryDTO.from(countryDAO));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        String nameformated = name.split(" ")[0];
        CountryDTO countryDTO = null;
        String url = "https://restcountries.com/v3.1/name/"+nameformated;
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            CountryDAO[] countryDAO = gson.fromJson(datos, CountryDAO[].class);
            countryDTO=CountryDTO.from(countryDAO[0]);
             countryDTO.setName(countryDTO.getName());
             countryDTO.setCoin(countryDTO.getCoin());
             countryDTO.setPopulation(countryDTO.getPopulation());
             countryDTO.setCapital(countryDTO.getCapital());
             countryDTO.setFlag(countryDTO.getFlag());
             countryDTO.setRegion(countryDTO.getRegion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countryDTO;
    }

    @Override
    public CountryDTO getCountryByCca3(String cca3) {
        CountryDTO countryDTO = null;
        String url= "";
        if (cca3!=null)
            url = "https://restcountries.com/v3.1/alpha/" + cca3;
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            CountryDAO[] countryDAO = gson.fromJson(datos, CountryDAO[].class);
            countryDTO=CountryDTO.from(countryDAO[0]);
            countryDTO.setName(countryDTO.getName());
            countryDTO.setCoin(countryDTO.getCoin());
            countryDTO.setPopulation(countryDTO.getPopulation());
            countryDTO.setCapital(countryDTO.getCapital());
            countryDTO.setFlag(countryDTO.getFlag());
            countryDTO.setRegion(countryDTO.getRegion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countryDTO;
    }

    private String getDataUrl(String url) throws IOException {
        URL obj = new URL(url);
        // Abrimos una conexión HTTP
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Establecemos el método de petición como GET
        con.setRequestMethod("GET");
        // Creamos un BufferedReader para leer la respuesta del servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        // Creamos un StringBuilder para almacenar la respuesta
        StringBuilder response = new StringBuilder();
        // Leemos línea por línea la respuesta y la añadimos al StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        // Cerramos el BufferedReader
        in.close();
        return response.toString();
    }
}
