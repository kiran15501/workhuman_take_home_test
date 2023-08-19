package com.search.country.models;

import org.springframework.data.mongodb.core.mapping.Document;

// POJO class for storing the counties names in the mongoDB
@Document
public class CountryDocument {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
