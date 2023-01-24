package com.simco.prickleback.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simco.prickleback.model.ShowQuestion;
import com.simco.prickleback.repo.QuestionRepository;

@Service
public class QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    // this character is used to delimit answers in the DB
    private static final String ANSWER_DELIMITER = "\\|";

    @Autowired
    private QuestionRepository questionRepository;

    public List<ShowQuestion> getRandomQuestions(int numberToGet) {
        // get the questions from the DB
        List<ShowQuestion> questions = questionRepository.findRandomQuestions(numberToGet);
        // do a little processing here: split answers into array, so the
        // client doesn't have to worry about it
        questions.stream().forEach(q -> {
            q.setAnswers(q.getAnswerString().split(ANSWER_DELIMITER));
            logger.debug("processing q=[{}], answerString=[{}], length of answers[]=[{}]", q.getQuestion(), q.getAnswerString(), q.getAnswers().length);
        });
        return questions;
    }

}
