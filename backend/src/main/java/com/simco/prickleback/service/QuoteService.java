package com.simco.prickleback.service;

import java.util.Random;

import org.springframework.stereotype.Controller;

import com.simco.prickleback.model.Grade;

@Controller
public class QuoteService {

    private static final String[] ENCOURAGEMENT = {
            "Rock on!",
            "Keep this train rolling!",
            "It's show time!",
            "And now the magic begins!",
            "Time to get cracking!",
            "Let's go!",
            "Things are moving now!",
            "Knock this one out of the park!",
            "Way to go!",
            "Nice job! Next!",
            "The fans are ready for this!",
            "Give them what they want!",
            "They're screaming your name!",
    };

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
            "I think you're a great fan of music.",
            "Really digging your lyrical groove.",
    };

    private static final String[] SCORE_REACTIONS_C = {
            "Not too bad, maybe reduce your Justin Bieber time.",
            "Keep learning!",
            "Practice makes perfect.  Keep practicing!",
            "Keep doing what you're doing, and one day you'll be a star.",
            "No shame earning a score like that.",
            "You really know some song lyrics, don't you?",
            "Pretty good job, let's keep improving.",
            "Hey, middle of the road is still ON the road.",
            "One of these days you're gonna get it just right!",
            "There's room for improvement, but nice work so far.",
            "If only everyone did this well.",
            "Music could be your thing. Keep improving.",
    };

    private static final String[] SCORE_REACTIONS_D = {
            "Were you just clicking randomly?",
            "Pro tip: always click the third choice!",
            "My uncle got that score too, but he was blindfolded.",
            "Yeah, we know you can do better.",
            "Tell the game admin to increase the time limit.",
            "Some days that bear, he eats you.",
            "We've had better days, haven't we?",
            "Suck it up and keep trying.",
            "You'll do better next time!",
            "I guess you could have done worse.  So, good job.",
            "Don't get discouraged by this.  Try again.",
            "Maybe go with different answers next time.",
            "Hey, it could have been worse...but only barely.",
            "You did better than some journalists.",
            "Not bad for a beginner.",
            "Lyrics aren't for everyone, but you have time to be better.",
    };

    private static final String[] SCORE_REACTIONS_E = {
            "Good lord, you're the worst.",
            "Just unacceptable.",
            "Wow, you should really try again.",
            "Please, try one more time.",
            "Simply terrible.",
            "It doesn't get much worse, does it?",
            "Please. Listen to some quality music.",
            "We can't all be winners, eh?",
            "Please, no more.",
            "Just...no.",
            "Absolutely dreadful.",
            "I need to join a new band.",
            "You may need to flee the country.",
            "I hope our label doesn't drop us.",
            "No offense, but I may ask our agent to...replace you.",
            "If that's how you tour, I don't think I want to tour anymore.",
            "Nice to meet you, Captain McFail.",
            "Give me the last five minutes of my life back.",
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
