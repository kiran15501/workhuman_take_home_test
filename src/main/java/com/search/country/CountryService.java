package com.search.country;

import com.search.country.models.CountryDocument;
import com.search.country.models.User_data;
import com.search.country.repository.CountryRepository;
import com.search.country.repository.User_detailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class CountryService {

   @Autowired
    public CountryRepository countryRepository;

   @Autowired
   public User_detailsRepository userDetailsRepository;


   // Saving each country in the monogoDB using the MonogDB template
    public void saveCountry(List<String> countries) {
        countries.forEach(country -> {
            CountryDocument countryDocument = new CountryDocument();
            countryDocument.setName(country);
            countryRepository.save(countryDocument);
        });

    }

    // Obtaining the countries with the given sub string
    public List<CountryDocument> getDocumentsContainingString(String searchString) {
        return countryRepository.findByNameContainingIgnoreCase(searchString);
    }

    //Inserting the User data in mangoDb
    public void insert_userData( User_data userData) {
        userDetailsRepository.save(userData);
    }

    }
