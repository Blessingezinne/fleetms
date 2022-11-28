package com.zinnythebeginner.fleetms.parameters.controllers;

import com.zinnythebeginner.fleetms.parameters.models.State;
import com.zinnythebeginner.fleetms.parameters.services.CountryService;
import com.zinnythebeginner.fleetms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StateController {
    @Autowired private StateService stateService;

    @Autowired public CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    @GetMapping("/parameters/states")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/parameters/states/{op}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.findById(id));
        return "/parameters/states" + op;
    }

    //Add State
    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value="/parameters/states/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }

}
