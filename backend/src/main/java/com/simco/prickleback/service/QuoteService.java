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
            "Best tour EVER!",
            "Thanks for some really amazing shows this year.",
            "Amazing stuff, great job!",
            "That was freaking epic!",
            "Best shows ever!",
            "A tour like that - that's why I'm in the business.",
    };

    private static final String[] SCORE_REACTIONS_B = {
            "Great!",
            "Keep striving for perfection.",
            "If you never get better than this, that's still okay.",
            "Keep rocking!",
            "You did better than most!",
            "Your parents would be so proud of that score.",
            "You crushed it!",
            "Hey man, aim for the stars, you know?",
            "That effort was truly righteous!",
            "No way, great score!",
            "We pulled together and delivered a great tour.",
            "Some of my favorite shows were on this tour.",
    };

    private static final String[] SCORE_REACTIONS_C = {
            "Not too bad, keep studying.",
            "Keep learning!",
            "Practice makes perfect.  Keep practicing!",
            "Keep doing what you're doing, and one day you'll be a star.",
            "No shame earning a score like that.",
            "You really know some song lyrics, don't you?",
            "Pretty good job, let's keep improving.",
            "Hey, middle of the road is still ON the road.",
            "One of these days you're gonna get it just right!",
            "There's room for improvement, but nice work so far.",
    };

    private static final String[] SCORE_REACTIONS_D = {
            "Were you just clicking randomly?",
            "Pro tip: always click the third choice!",
            "My uncle got that score too, but he was blindfolded.",
            "Yeah, we know you can do better.",
            "Tell the game admin to increase the time limit.",
            "Some days that bear, he eats you.",
            "We've had better days, haven't we?",
            "Suck it up and keep learning.",
            "You'll do better next time!",
            "I guess you could have done worse.  So, good job.",
            "Don't get discouraged by this.  Try again.",
            "Maybe go with different answers next time.",
            "Hey, it could have been worse...but only barely.",
            "You did better than some journalists.",
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
            "You may need to flee the country.",
            "I hope our label doesn't drop us.",
            "No offense, but I may ask our agent to...replace you.",
            "If that's how you tour, I don't think I want to tour anymore.",
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
