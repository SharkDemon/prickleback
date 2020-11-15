package com.simco.prickleback.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Tour {

    private String name;
    private List<Show> shows;

    public boolean allShowsCompleted() {
        boolean result = true;
        if (null != shows) {
            for (Show show : shows) {
                if (!show.allQuestionsAnswered()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public Show getActiveShow() {
        Show result = null;
        for (Show show : shows) {
            if (!show.allQuestionsAnswered()) {
                return show;
            }
        }
        return result;
    }

    public ShowQuestion getActiveQuestion() {
        Show show = getActiveShow();
        for (ShowQuestion q : show.getShowQuestions()) {
            if (null == q.getAnsweredCorrectly()) {
                return q;
            }
        }
        return null;
    }

    public Score getCurrentScore() {
        int current = 0;
        int max = 0;
        int overallMax = 0;
        for (Show show : shows) {
            for (ShowQuestion q : show.getShowQuestions()) {
                overallMax += q.getScore();
                if (null != q.getAnsweredCorrectly()) {
                    max += q.getScore();
                    if (Boolean.TRUE.equals(q.getAnsweredCorrectly())) {
                        current += q.getScore();
                    }
                }
            }
        }
        return Score.builder()
                .currentScore(current)
                .maxScore(max)
                .overallMaxScore(overallMax)
                .build();

    }

}
