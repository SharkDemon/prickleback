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

    public Score setGrade(Score score) {
        double percentage = score.getCurrentScore() / score.getOverallMaxScore() * 100;
        logger.info("setGrade() percentage=[{}]", percentage);

        if (Grade.A.getThreshold() <= percentage) {
            score.setGrade(Grade.A);
        }
        else if (Grade.B.getThreshold() <= percentage) {
            score.setGrade(Grade.B);
        }
        else if (Grade.C.getThreshold() <= percentage) {
            score.setGrade(Grade.C);
        }
        else if (Grade.D.getThreshold() <= percentage) {
            score.setGrade(Grade.D);
        }
        else {
            score.setGrade(Grade.E);
        }
        return score;
    }

    public Score setReactions(Score score) {
        score.setLeadReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        score.setRhythmReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        score.setBassistReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        score.setDrummerReaction( quoteService.getRandomReactionForGrade(score.getGrade()) );
        return score;
    }

}
