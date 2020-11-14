package com.simco.prickleback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.simco.prickleback.model.AppInfo;

@Controller
public class IndexController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String showIndex(
            @ModelAttribute("appInfo") AppInfo appInfo,
            Model model) {

        logger.info("showIndex() invoked");

        // add session variables
        model.addAttribute("currentBand", null);
        model.addAttribute("currentTour", null);
        // add data necessary to render view
        model.addAttribute("appInfo", appInfo);
        return "index";
    }

}
