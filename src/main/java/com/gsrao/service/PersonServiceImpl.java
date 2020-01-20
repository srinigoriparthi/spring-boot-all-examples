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
    public Person createPerson(Person person) {
        long totalCount = personRepository.count();
        LOGGER.info("Total Count of Existing Persons:{}",totalCount);
        String id = String.valueOf(totalCount+1);
        person.setId(id);
        personRepository.save(person);
        Optional<Person> savedPerson = personRepository.findById(id);
        if(savedPerson.isPresent()){
            LOGGER.info("Person saved successfully with the Id:{}",savedPerson.get().getId());
            return savedPerson.get();
        }else{
            LOGGER.warn("Person saving is Failed with the Id:{}",person.getId());
            return savedPerson.get();
        }

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
    public String updatePerson(Person person, String id) {
        Optional<Person> result = personRepository.findById(String.valueOf(id));

        if(result.isPresent()) {
            Person exisPerson = result.get();
            exisPerson.setId(id);
            exisPerson.setFirstName(person.getFirstName());
            exisPerson.setLastName(person.getLastName());
            exisPerson.setEmail(person.getEmail());
            exisPerson.setPhone(person.getPhone());
            exisPerson.setAddress(person.getAddress());
            exisPerson.setCreatdttime(new Date());
            personRepository.save(exisPerson);
            Optional<Person> updatedPerson = personRepository.findById(String.valueOf(id));
            if(updatedPerson.isPresent()){
                LOGGER.info("Person Updated successfully with the Id:{}",updatedPerson.get().getId());
                return "Person Updated successfully with the Id:"+updatedPerson.get().getId();
            }else{
                LOGGER.warn("Person Updation got Failed with the Id:{}",person.getId());
                return "Person Updation got Failed with the Id:"+id;
            }
        }else{
            return "Person not Found:"+id;
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
