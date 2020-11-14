package com.simco.prickleback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.simco.prickleback.model.AppInfo;
import com.simco.prickleback.model.Band;
import com.simco.prickleback.service.CityService;
import com.simco.prickleback.service.PersonService;

@Controller
@SessionAttributes({"appInfo", "currentBand"})
public class BaseController {

    @Autowired
    protected PersonService personService;
    @Autowired
    protected CityService cityService;

    @ModelAttribute("appInfo")
    public AppInfo applicationInfo() {
        return AppInfo.builder()
                .title("Fantasy Rockband")
                .build();
    }

    // keep the current Band object in session
    @ModelAttribute("currentBand")
    public Band currentBand() {
        return new Band();
    }

}
