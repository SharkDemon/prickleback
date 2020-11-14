package com.simco.prickleback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.Person;
import com.simco.prickleback.service.CityService;
import com.simco.prickleback.service.PersonService;

@Controller
public class BandController {

    private static final Logger logger = LoggerFactory.getLogger(BandController.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private CityService cityService;

    @GetMapping("/choose-members")
    public String showChooseMembers(Model model) {

        logger.info("showChooseMembers() invoked");

        List<Person> leads = personService.getAllLeads();
        List<Person> drummers = personService.getAllDrummers();
        List<Person> bassists = personService.getAllBassists();
        List<Person> rhythms = personService.getAllRhythms();
        logger.info("getAllLeads() returned [{}] leads, [{}] drummers, [{}] bassists, [{}] rhythms",
                leads.size(), drummers.size(), bassists.size(), rhythms.size());

        // add data necessary to render view
        model.addAttribute("applicationTitle", "Fantasy Rockband");
        model.addAttribute("leads", leads);
        model.addAttribute("drummers", drummers);
        model.addAttribute("bassists", bassists);
        model.addAttribute("rhythms", rhythms);
        model.addAttribute("newBand", new Band());
        return "chooseMembers";
    }

    @PostMapping("/choose-members")
    public String chooseMembers(
            @ModelAttribute Band band,
            ModelMap model) {

        logger.info("chooseMembers() invoked - lead=[{}], rhythm=[{}], bassist=[{}], drummer=[{}]",
                band.getLead().getDisplayValue(),
                band.getRhythm().getDisplayValue(),
                band.getBassist().getDisplayValue(),
                band.getDrummer().getDisplayValue());

        return "chooseName";
    }

}
