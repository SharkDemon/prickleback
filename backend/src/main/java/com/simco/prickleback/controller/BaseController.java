package com.simco.prickleback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.simco.prickleback.model.AppInfo;
import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.Tour;
import com.simco.prickleback.service.CityService;
import com.simco.prickleback.service.PersonService;
import com.simco.prickleback.service.QuoteService;
import com.simco.prickleback.service.ReferenceDataService;
import com.simco.prickleback.service.ScoringService;
import com.simco.prickleback.service.TourService;

@Controller
@SessionAttributes({"appInfo", "currentBand", "currentTour"})
public class BaseController {

    @Autowired
    protected PersonService personService;
    @Autowired
    protected CityService cityService;
    @Autowired
    protected ReferenceDataService referenceDataService;
    @Autowired
    protected TourService tourService;
    @Autowired
    protected QuoteService quoteService;
    @Autowired
    protected ScoringService scoringService;

    @ModelAttribute("appInfo")
    public AppInfo applicationInfo() {
        return AppInfo.builder()
                .title("Prickleback")
                .hackathon("Do-Re-Mi Hacks 2020")
                .build();
    }

    // keep the current Band object in session
    @ModelAttribute("currentBand")
    public Band currentBand() {
        return null;
    }

    // keep the current Tour object in session
    @ModelAttribute("currentTour")
    public Tour currentTour() {
        return null;
    }

}
