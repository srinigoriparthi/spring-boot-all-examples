package com.gsrao.service;

import com.gsrao.model.Person;

import java.util.List;

/**
 *  PersonService Interface
 */
public interface PersonService {

    public abstract void createPerson(Person person);
    public abstract Person getPerson(String id);
    public abstract void updatePerson(Person person, String id);
    public abstract List<Person> getPersons();
    public abstract void deletePerson(String id);
}
