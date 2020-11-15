package com.simco.prickleback.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Show {

    private static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("d");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MMM");
    private static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");

    private City city;
    private LocalDateTime date;

    private List<ShowQuestion> showQuestions;

    public String getDayDisplay() {
        return DAY_FORMATTER.format(date);
    }

    public String getMonthDisplay() {
        return MONTH_FORMATTER.format(date);
    }

    public String getYearDisplay() {
        return YEAR_FORMATTER.format(date);
    }

    public boolean allQuestionsAnswered() {
        boolean result = true;
        if (null != showQuestions) {
            for (ShowQuestion q : showQuestions) {
                if (null == q.getAnsweredCorrectly()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    // essentially the 1-based index
    public int getActiveQuestionNumber() {
        int result = 1;
        for (ShowQuestion q : showQuestions) {
            if (null == q.getAnsweredCorrectly()) {
                return result;
            }
            result++;
        }
        return result;
    }


}
