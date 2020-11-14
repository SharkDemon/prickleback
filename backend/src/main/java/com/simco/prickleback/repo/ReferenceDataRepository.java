package com.simco.prickleback.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simco.prickleback.model.ReferenceData;

@Repository
public interface ReferenceDataRepository extends JpaRepository<ReferenceData, Integer> {

    List<ReferenceData> findByTypeOrderByValue(String refValue);

    default List<ReferenceData> findAllBandNameAdjectives() {
        return findByTypeOrderByValue(ReferenceData.ADJECTIVES);
    }

    default List<ReferenceData> findAllBandNameNouns() {
        return findByTypeOrderByValue(ReferenceData.NOUNS);
    }

    default List<ReferenceData> findAllBandColors() {
        return findByTypeOrderByValue(ReferenceData.COLORS);
    }

}
