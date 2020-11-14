package com.simco.prickleback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ShowQuestion {

    // TODO: should have placeholders?
    private String question;

    private String[] answers;
    private int correctAnswerIndex;

    private Boolean answeredCorrectly;

    private int score;

    private String imagePath;

    public String getAnswerColor() {
        if (null == answeredCorrectly) {
            return "#EAECEE"; // gray
        }
        return Boolean.TRUE.equals(answeredCorrectly)
                ? "#7DCEA0" // green
                        : "#D98880"; // red
    }

}
