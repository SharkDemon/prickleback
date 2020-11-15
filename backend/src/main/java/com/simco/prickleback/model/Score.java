package com.simco.prickleback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Score {

    private int currentScore;
    private int maxScore;
    private int overallMaxScore;

    private Grade grade;

    private String leadReaction;
    private String rhythmReaction;
    private String bassistReaction;
    private String drummerReaction;

}
