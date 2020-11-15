package com.simco.prickleback.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.Show;
import com.simco.prickleback.model.ShowQuestion;
import com.simco.prickleback.model.Tour;

@Service
public class TourService {

    private static final Logger logger = LoggerFactory.getLogger(TourService.class);

    private static final int SHOWS_PER_TOUR = 3;
    private static final int QUESTIONS_PER_SHOW = 3;

    private static final int NORMAL_SHOW_SCORE_MULTIPLIER = 10;
    // TODO: not using this one yet!
    private static final int HOMETOWN_SHOW_SCORE_MULTIPLIER = 15;

    @Autowired
    private CityService cityService;
    @Autowired
    private QuestionService questionService;

    public Tour createTour(Band band) {

        // get an appropriate number of (randomized) questions from the DB;
        // these will be used to build out the Tour
        List<ShowQuestion> randomQuestions = questionService.getRandomQuestions(SHOWS_PER_TOUR * QUESTIONS_PER_SHOW);
        logger.debug("TourService.createTour() retrieved randomQuestions.size=[{}]", randomQuestions.size());

        int dateOffset = 0;

        // (1) to build a Tour, we need a LocalDateTime and list of Shows
        LocalDateTime now = LocalDateTime.now();

        // (2) build the list of Shows
        List<Show> shows = new ArrayList<Show>(SHOWS_PER_TOUR);
        for (int i = 0; i < SHOWS_PER_TOUR; i++) {

            // (3) to build a Show, we need a list of ShowQuestions
            List<ShowQuestion> showQuestions = new ArrayList<ShowQuestion>(QUESTIONS_PER_SHOW);
            // (4) build the list of ShowQuestions
            for (int j = 0; j < QUESTIONS_PER_SHOW; j++) {
                logger.debug("TourService.createTour() getting question index=[{}]", (i*SHOWS_PER_TOUR)+j);
                ShowQuestion question = randomQuestions.get( (i*SHOWS_PER_TOUR) + j );
                question.setScore((j + 1) * NORMAL_SHOW_SCORE_MULTIPLIER);
                showQuestions.add(question);
            }

            Show show = Show.builder()
                    .city(i == SHOWS_PER_TOUR - 1 ? band.getHometown() : cityService.getRandomCity())
                    .date(now.plusDays(dateOffset))
                    .showQuestions(showQuestions)
                    .build();
            shows.add(show);
            dateOffset += getRandomInt();
        }

        Tour tour = Tour.builder()
                .name(String.format("%s US Tour %s", band.getName(), now.getYear()))
                .shows(shows)
                .build();

        return tour;
    }

    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(1, 4);
    }

    // min and max are (inclusive) range
    public int getRandomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min)+1) + min;
    }

}
