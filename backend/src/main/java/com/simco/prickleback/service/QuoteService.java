package com.simco.prickleback.service;

import java.util.Random;

import org.springframework.stereotype.Controller;

import com.simco.prickleback.model.Grade;

@Controller
public class QuoteService {

    private static final String[] SCORE_REACTIONS_A = {
            "Amazing job!",
            "Incredible work!",
            "You are the best!",
            "Does it get any better?",
            "Simply stupendous.",
            "Superb. Will you be my tutor?",
            "You are a points-scoring beast!",
            "Heavenly perfection!",
    };

    private static final String[] SCORE_REACTIONS_B = {
            "Great!",
            "Keep striving for perfection.",
            "If you never get better than this, that's still okay.",
            "Keep rocking!",
            "You did better than most!",
            "Your parents would be so proud of that score.",
            "You crushed it!",
    };

    private static final String[] SCORE_REACTIONS_C = {
            "Not too bad, keep studying.",
            "Keep learning!",
            "Practice makes perfect.  Keep practicing!",
            "Keep doing what you're doing, and one day you'll be a star.",
            "No shame earning a score like that.",
            "You really know some song lyrics, don't you?",
            "Pretty good job, let's keep improving.",
    };

    private static final String[] SCORE_REACTIONS_D = {
            "Were you just clicking randomly?",
            "Pro tip: always click the third choice!",
            "My uncle got that score too, but he was blindfolded.",
            "Yeah, we know you can do better.",
            "Tell the game admin to increase the time limit.",
            "Some days the bear eats you.",
            "We've had better days, haven't we?",
            "Suck it up and keep learning.",
            "You'll do better next time!",
    };

    private static final String[] SCORE_REACTIONS_E = {
            "Good lord, you're the worst.",
            "Simply terrible.",
            "It doesn't get much worse, does it?",
            "Please study some more and try again.",
            "We can't all be winners, eh?",
            "Please, no more.",
            "Just...no.",
            "Absolutely dreadful.",
            "I need to join a new band.",
    };

    public String getRandomReactionForGrade(Grade grade) {
        if (Grade.A.equals(grade))
            return getRandomElementFromArray(SCORE_REACTIONS_A);
        else if (Grade.B.equals(grade))
            return getRandomElementFromArray(SCORE_REACTIONS_B);
        else if (Grade.C.equals(grade))
            return getRandomElementFromArray(SCORE_REACTIONS_C);
        else if (Grade.D.equals(grade))
            return getRandomElementFromArray(SCORE_REACTIONS_D);
        else
            return getRandomElementFromArray(SCORE_REACTIONS_E);
    }

    private String getRandomElementFromArray(String[] arr) {
        return arr[ new Random().nextInt(arr.length) ];
    }

}
