package com.simco.prickleback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simco.prickleback.model.AppInfo;
import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.City;
import com.simco.prickleback.model.Person;
import com.simco.prickleback.model.ReferenceData;
import com.simco.prickleback.model.Tour;

@Controller
public class BandController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BandController.class);

    @GetMapping("/choose-members")
    public String showChooseMembers(
            @ModelAttribute("appInfo") AppInfo appInfo,
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute("currentTour") Tour currentTour,
            Model model) {

        logger.debug("showChooseMembers() invoked");

        List<Person> leads = personService.getAllLeads();
        List<Person> drummers = personService.getAllDrummers();
        List<Person> bassists = personService.getAllBassists();
        List<Person> rhythms = personService.getAllRhythms();
        logger.debug("getAllLeads() returned [{}] leads, [{}] drummers, [{}] bassists, [{}] rhythms",
                leads.size(), drummers.size(), bassists.size(), rhythms.size());

        // add data necessary to render view
        model.addAttribute("appInfo", appInfo);
        model.addAttribute("leads", leads);
        model.addAttribute("drummers", drummers);
        model.addAttribute("bassists", bassists);
        model.addAttribute("rhythms", rhythms);
        model.addAttribute("newBand", new Band());
        return "chooseMembers";
    }

    @PostMapping("/choose-members")
    public ModelAndView chooseMembers(
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute Band band,
            ModelMap model) {

        logger.info("chooseMembers() invoked - lead=[{}], rhythm=[{}], bassist=[{}], drummer=[{}]",
                band.getLead().getDisplayValue(),
                band.getRhythm().getDisplayValue(),
                band.getBassist().getDisplayValue(),
                band.getDrummer().getDisplayValue());

        // save selected band members to state object
        if (null == currentBand) {
            currentBand = Band.builder().build();
        }
        currentBand.setLead(band.getLead());
        currentBand.setRhythm(band.getRhythm());
        currentBand.setBassist(band.getBassist());
        currentBand.setDrummer(band.getDrummer());

        model.addAttribute("currentBand", currentBand);
        return new ModelAndView("redirect:/choose-name", model);
    }

    @GetMapping("/choose-name")
    public String showChooseName(
            @ModelAttribute("appInfo") AppInfo appInfo,
            Model model) {

        logger.debug("showChooseName() invoked");

        List<ReferenceData> adjectives = referenceDataService.getAllBandNameAdjectives();
        List<ReferenceData> nouns = referenceDataService.getAllBandNameNouns();
        List<City> cities = cityService.getAllCities();
        List<ReferenceData> colors = referenceDataService.getAllBandColors();

        // add data necessary to render view
        model.addAttribute("appInfo", appInfo);
        model.addAttribute("adjectives", adjectives);
        model.addAttribute("nouns", nouns);
        model.addAttribute("cities", cities);
        model.addAttribute("colors", colors);
        model.addAttribute("newNameInfo", new Band());
        return "chooseName";
    }

    @PostMapping("/choose-name")
    public ModelAndView chooseName(
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute Band band,
            ModelMap model) {

        logger.info("chooseName() invoked - name=[{}], hometown=[{}], color=[{}]",
                band.getName(),
                band.getHometown().getDisplayValue(),
                band.getColor());

        // save selected band members to state object
        currentBand.setNameAdjective(band.getNameAdjective());
        currentBand.setNameNoun(band.getNameNoun());
        currentBand.setHometown(band.getHometown());
        currentBand.setColor(band.getColor());

        model.addAttribute("currentBand", currentBand);
        return new ModelAndView("redirect:/" + VIEW_TOUR, model);
    }

}
