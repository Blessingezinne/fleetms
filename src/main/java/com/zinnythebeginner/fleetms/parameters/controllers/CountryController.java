package com.zinnythebeginner.fleetms.parameters.controllers;


import com.zinnythebeginner.fleetms.parameters.models.Country;
import com.zinnythebeginner.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/parameters/countries")
    public String getAll(Model model){
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        return "/parameters/countries";
    }
    @GetMapping("/parameters/countryAdd")
    public String addCountry(){
     return "parameters/countryAdd";
    }
    @GetMapping("/parameters/country/{op}/{id}")
    public String editCountry(@PathVariable Integer id, @PathVariable String op, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "/parameters/countries"+ op;
    }
    @PostMapping("/parameters/countries")
    public String save(Country country){
        countryService.save(country);
        return "/parameters/countries";
    }
    @RequestMapping(value = "/parameters/countries/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "/parameters/countries";
    }
    @RequestMapping(value = "/parameters/countries/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Country country){
        countryService.save(country);
        return "/parameters/countries";
    }

    @GetMapping("/parameters/countryDetails/{id}")
    public String detailsCountry(@PathVariable Integer id,Model model) {
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryDetails";

    }
}
