package com.search.country.repository;

import com.search.country.models.User_data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Creating the repository to store User_Data
@Repository
public interface User_detailsRepository extends MongoRepository<User_data, String> {
}
