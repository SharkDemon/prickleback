package com.simco.prickleback.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simco.prickleback.model.Grade;
import com.simco.prickleback.model.Score;

@Service
public class ScoringService {

    private static final Logger logger = LoggerFactory.getLogger(ScoringService.class);

    @Autowired
    private QuoteService quoteService;

    public Grade getGrade(Score score) {

        logger.info("getGrade() score=[{}], maxScore=[{}]", score.getCurrentScore(), score.getOverallMaxScore());

        double percentage = 100 * score.getCurrentScore() / score.getOverallMaxScore();
        logger.info("getGrade() percentage=[{}]", percentage);

        if (Grade.A.getThreshold() <= percentage) {
            return Grade.A;
        }
        else if (Grade.B.getThreshold() <= percentage) {
            return Grade.B;
        }
        else if (Grade.C.getThreshold() <= percentage) {
            return Grade.C;
        }
        else if (Grade.D.getThreshold() <= percentage) {
            return Grade.D;
        }
        else {
            return Grade.E;
        }
    }

    public Score setReactions(Score score) {
        score.setLeadReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        score.setRhythmReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        score.setBassistReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        score.setDrummerReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        return score;
    }

}
