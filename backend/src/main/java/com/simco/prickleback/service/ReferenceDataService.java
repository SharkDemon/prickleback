package com.simco.prickleback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simco.prickleback.model.ReferenceData;
import com.simco.prickleback.repo.ReferenceDataRepository;

@Service
public class ReferenceDataService {

    @Autowired
    private ReferenceDataRepository repository;

    public List<ReferenceData> getAllBandNameAdjectives() {
        return repository.findAllBandNameAdjectives();
    }

    public List<ReferenceData> getAllBandNameNouns() {
        return repository.findAllBandNameNouns();
    }

    public List<ReferenceData> getAllBandColors() {
        return repository.findAllBandColors();
    }

}
