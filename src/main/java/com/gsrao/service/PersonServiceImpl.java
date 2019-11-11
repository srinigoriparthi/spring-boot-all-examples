package com.gsrao.service;

import com.datastax.driver.core.LocalDate;
import com.gsrao.dao.PersonRepository;
import com.gsrao.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonServiceImpl implements  PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public void createPerson(Person person) {
       /* Iterable<Person> persLstResult = personRepository.findAll();
        List<Person> personList = new ArrayList<>();
        persLstResult.forEach(personList::add);
        String id = String.valueOf(personList.size()+1);
        person.setId(id);*/
        personRepository.save(person);
    }

    @Override
    public Person getPerson(String id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return person.get();
        }else{
            return null;
        }
    }

    @Override
    public void updatePerson(Person person, String id) {
        Optional<Person> result = personRepository.findById(String.valueOf(id));

        if(result.isPresent()) {
            Person exisPerson = result.get();
            exisPerson.setId(id);
            exisPerson.setFirstName(person.getFirstName());
            exisPerson.setLastName(person.getLastName());
            exisPerson.setEmail(person.getEmail());
            exisPerson.setPhone(person.getPhone());
            exisPerson.setAddress(person.getAddress());
            personRepository.save(exisPerson);
        }
    }

    @Override
    public List<Person> getPersons() {
        Iterable<Person> persLstResult = personRepository.findAll();
        List<Person> personList = new ArrayList<>();
        persLstResult.forEach(personList::add);
        return personList;
    }

    @Override
    public void deletePerson(String id) {
        boolean existsId = personRepository.existsById(id);
        if(existsId)
            personRepository.deleteById(id);
    }
}
