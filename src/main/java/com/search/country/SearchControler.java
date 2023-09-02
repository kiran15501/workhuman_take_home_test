package com.search.country;

import com.search.country.models.CountryDocument;
import com.search.country.models.User_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SearchControler {

    @Autowired
    private final CountryService countryService;

    public SearchControler(CountryService countryService) {
        this.countryService = countryService;
    }



    // The Api  uses the Get  method to obtain the countries name which contains with given  parm string and returns the List of countries
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CountryDocument>  autocompleteSuggestions(@RequestParam("search_name") String search_name) {
      //  System.out.println("search_name: " + search_name);

        //obtaining the countries name
        List<CountryDocument> sample=countryService.getDocumentsContainingString(search_name);
        return sample;

        // The below code stores the names of the countries in Hashset and checks for contains

//        Set<String> countrySet = new HashSet<>(Arrays.asList(countries));
//        List<String> suggestions = new ArrayList<>();
//
//        for (String country : countrySet) {
//            if (country.toLowerCase().contains(search_name.toLowerCase())) {
//                suggestions.add(country);
//            }
//        }
//        int n = Math.min(suggestions.size(), 10);
//        return new ArrayList<>(suggestions.subList(0, n));
    }

    // The Api  uses the Post method  to Store all the details of the user in mongoDB
    @RequestMapping(value = "/form_sample", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String user_Register(@ModelAttribute User_data userData){
        countryService.insert_userData(userData);
        return "submitted Successfully";
    }
    // The Api uses Get method  to Store all the countries name that is given in the document in mongoDB
    @RequestMapping(value = "/insert", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String insertCountries() {
        //list of countries
        List<String> countryNames = Arrays.asList(
                "Albania", "Andorra", "Australia", "Brazil", "Belgium", "Canada","China", "France","Germany","India","Indonesia","Ireland","Italy", "Japan",
                "Kenya", "Luxembourg", "Mexico", "New Zealand", "Nigeria", "Portugal", "Russia", "South Africa", "South Korea", "Spain", "Sweden", "Thailand",
                "Ukraine", "United Kingdom", "United States of America", "Vietnam", "Zambia");
        countryService.saveCountry(countryNames);
        return "Countries inserted";
    }

}
