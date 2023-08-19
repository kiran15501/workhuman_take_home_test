package com.search.country.models;


import org.springframework.data.mongodb.core.mapping.Document;
//pojo class of the User Data to store in mongoDB
@Document
public class User_data {
    public String name;
    public String email;
    public String country;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+email+country;
    }
}
