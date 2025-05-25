// File: src/test/java/com/gsrao/service/PersonServiceImplTest.java
package com.gsrao.service;

import com.gsrao.dao.PersonRepository;
import com.gsrao.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    private Person person;

    @Before
    public void setUp() {
        person = new Person();
        person.setId("1");
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("john@example.com");
        person.setPhone("1234567890");
        person.setAddress("123 Main St");
    }

    @Test
    public void testCreatePerson() {
        when(personRepository.count()).thenReturn(0L);
        when(personRepository.save(any(Person.class))).thenReturn(person);
        when(personRepository.findById("1")).thenReturn(Optional.of(person));

        Person created = personService.createPerson(person);

        assertNotNull(created);
        assertEquals("1", created.getId());
        verify(personRepository).save(any(Person.class));
        System.out.println("Person Created successfully with ID: " + created.getId());
    }

    @Test
    public void testGetPerson_Found() {
        when(personRepository.findById("1")).thenReturn(Optional.of(person));
        Person found = personService.getPerson("1");
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
    }

    @Test
    public void testGetPerson_NotFound() {
        when(personRepository.findById("2")).thenReturn(Optional.empty());
        Person found = personService.getPerson("2");
        assertNull(found);
    }

    @Test
    public void testUpdatePerson_Found() {
        when(personRepository.findById("1")).thenReturn(Optional.of(person));
        when(personRepository.save(any(Person.class))).thenReturn(person);
        when(personRepository.findById("1")).thenReturn(Optional.of(person));

        String result = personService.updatePerson(person, "1");
        assertTrue(result.contains("Person Updated successfully"));
    }

    @Test
    public void testUpdatePerson_NotFound() {
        when(personRepository.findById("2")).thenReturn(Optional.empty());
        String result = personService.updatePerson(person, "2");
        assertTrue(result.contains("Person not Found"));
    }

    @Test
    public void testGetPersons() {
        List<Person> persons = Arrays.asList(person);
        when(personRepository.findAll()).thenReturn(persons);

        List<Person> result = personService.getPersons();
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
    }

    @Test
    public void testDeletePerson_Exists() {
        when(personRepository.existsById("1")).thenReturn(true);
        doNothing().when(personRepository).deleteById("1");
        personService.deletePerson("1");
        verify(personRepository).deleteById("1");
    }

    @Test
    public void testDeletePerson_NotExists() {
        when(personRepository.existsById("2")).thenReturn(false);
        personService.deletePerson("2");
        verify(personRepository, never()).deleteById("2");
    }
}