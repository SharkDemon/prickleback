package com.simco.prickleback.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="questions")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ShowQuestion {

    // these are database properties

    @Id private Integer id;
    // NOTE: the question has a placeholder in it
    private String question;

    @Column(name="answer_string")
    private String answerString;

    @Transient
    private String[] answers;

    @Column(name="correct_answer_index")
    private int correctAnswerIndex;

    @Column(name="image_name")
    private String imageName;

    private String song;
    private String band;
    private UUID uid;

    // these are game-context based properties

    @Transient
    private Boolean answeredCorrectly;
    @Transient
    private int score;

    // display helpers

    public String getAnswerColor() {
        if (null == answeredCorrectly) {
            return "#EAECEE"; // gray
        }
        return Boolean.TRUE.equals(answeredCorrectly)
                ? "#7DCEA0" // green
                        : "#D98880"; // red
    }

}
