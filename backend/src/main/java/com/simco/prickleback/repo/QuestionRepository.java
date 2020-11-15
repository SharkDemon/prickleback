package com.simco.prickleback.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simco.prickleback.model.ShowQuestion;

@Repository
public interface QuestionRepository extends JpaRepository<ShowQuestion, Integer> {

    @Query(value="SELECT * FROM questions q ORDER BY random() LIMIT :numberToReturn", nativeQuery=true)
    List<ShowQuestion> findRandomQuestions(@Param("numberToReturn") int num);

}
