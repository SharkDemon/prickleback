package com.simco.prickleback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.simco.prickleback.model.AppInfo;
import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.Tour;

@Controller
public class IndexController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public ModelAndView showIndex(
            @ModelAttribute("appInfo") AppInfo appInfo,
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute("currentTour") Tour currentTour,
            SessionStatus sessionStatus,
            ModelMap model) {

        logger.debug("showIndex() invoked");

        // if we have existing session data, end the session (killing those
        // attributes) and re-direct to index page
        if (null != currentBand || null != currentTour) {
            sessionStatus.setComplete();
            return new ModelAndView("redirect:/", model);
        }

        // add data necessary to render view
        model.addAttribute("appInfo", appInfo);
        return new ModelAndView("index", model);
    }

}
