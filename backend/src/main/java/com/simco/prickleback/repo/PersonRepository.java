package com.simco.prickleback.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simco.prickleback.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByRoleOrderByLastNameAsc(String role);
    List<Person> findByRole(String role);

    default List<Person> findAllLeads() {
        return findByRoleOrderByLastNameAsc(Person.ROLE_LEAD);
    }

    default List<Person> findAllDrummers() {
        return findByRoleOrderByLastNameAsc(Person.ROLE_DRUMMER);
    }

    default List<Person> findAllBassists() {
        return findByRoleOrderByLastNameAsc(Person.ROLE_BASSIST);
    }

    default List<Person> findAllRhythms() {
        return findByRoleOrderByLastNameAsc(Person.ROLE_RHYTHM);
    }

}
