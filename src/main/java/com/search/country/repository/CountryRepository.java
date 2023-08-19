package com.search.country.repository;
import com.search.country.models.CountryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// Creating the repository to store User_Data
@Repository
public interface CountryRepository extends MongoRepository<CountryDocument, String> {

    // Custom query to get the name of the countries which contains specific  string
    List<CountryDocument> findByNameContainingIgnoreCase(String searchString);
}
