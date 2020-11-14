package com.simco.prickleback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.simco.prickleback.model.AppInfo;

@Controller
public class TourController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TourController.class);

    @GetMapping("/tour")
    public String showTour(
            @ModelAttribute("appInfo") AppInfo appInfo,
            Model model) {

        logger.info("showTour() invoked");

        // TODO: get a list of random tour cities (and dates?)

        // add data necessary to render view
        model.addAttribute("applicationTitle", appInfo.getTitle());
        return "tour";
    }

}
