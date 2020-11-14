package com.simco.prickleback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simco.prickleback.model.Person;
import com.simco.prickleback.repo.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> getAllLeads() {
        return repository.findAllLeads();
    }

    public List<Person> getAllDrummers() {
        return repository.findAllDrummers();
    }

    public List<Person> getAllBassists() {
        return repository.findAllBassists();
    }

    public List<Person> getAllRhythms() {
        return repository.findAllRhythms();
    }

}
