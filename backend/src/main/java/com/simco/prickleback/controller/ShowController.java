package com.simco.prickleback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.QuestionForm;
import com.simco.prickleback.model.Show;
import com.simco.prickleback.model.ShowQuestion;
import com.simco.prickleback.model.Tour;

@Controller
public class ShowController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);

    @GetMapping("/goto-show")
    public ModelAndView showQuestion(
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute("currentTour") Tour currentTour,
            ModelMap model) {

        // if all questions of all shows are complete, navigate to completion page
        if (currentTour.allShowsCompleted()) {
            return new ModelAndView("redirect:/game-over", model);
        }
        // otherwise find which show and which question is active
        Show activeShow = currentTour.getActiveShow();
        ShowQuestion activeQuestion = currentTour.getActiveQuestion();

        // TODO: move this into a service call
        String animatedGifName = String.format("animated-%s.gif", tourService.getRandomNumber(1, 7));

        // add data necessary to render view
        model.addAttribute("activeShow", activeShow);
        model.addAttribute("activeQuestion", activeQuestion);
        model.addAttribute("questionForm", new QuestionForm());
        model.addAttribute("animatedGifName", animatedGifName);
        return new ModelAndView(VIEW_SHOW, model);
    }

    @PostMapping("/goto-show")
    public ModelAndView answerQuestion(
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute("currentTour") Tour currentTour,
            @ModelAttribute QuestionForm questionForm,
            ModelMap model) {

        ShowQuestion activeQuestion = currentTour.getActiveQuestion();

        logger.info("answerQuestion() invoked - question=[{}], submittedAnswer=[{}]",
                activeQuestion.getQuestion(),
                questionForm.getSubmittedAnswer());

        // mark the question as answered correctly or not, based whether or not
        // the user submitted the "correct answer's index"
        activeQuestion.setAnsweredCorrectly(
                questionForm.getSubmittedAnswer() == activeQuestion.getCorrectAnswerIndex() ?
                        Boolean.TRUE :
                            Boolean.FALSE);

        // add session variables
        model.addAttribute("currentBand", currentBand);
        model.addAttribute("currentTour", currentTour);
        return new ModelAndView("redirect:/goto-show", model);
    }



}
