package com.simco.prickleback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.simco.prickleback.model.AppInfo;
import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.Tour;

@Controller
public class TourController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TourController.class);

    @GetMapping("/tour")
    public String showTour(
            @ModelAttribute("appInfo") AppInfo appInfo,
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute("currentTour") Tour currentTour,
            Model model) {

        logger.info("showTour() invoked");

        // if Tour is null, we will build out a new Tour here!  we will
        // populate the Show dates and Questions as well
        if (null == currentTour) {
            currentTour = tourService.createTour(currentBand);
        }

        // add session variables
        model.addAttribute("currentTour", currentTour);
        // add data necessary to render view
        model.addAttribute("applicationTitle", appInfo.getTitle());
        model.addAttribute("bandName", currentBand.getName());
        return "tour";
    }

}
