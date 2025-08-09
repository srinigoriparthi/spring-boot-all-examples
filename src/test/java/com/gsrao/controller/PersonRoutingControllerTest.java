// File: src/test/java/com/gsrao/controller/PersonRoutingControllerTest.java
package com.gsrao.controller;

import com.gsrao.model.Person;
import com.gsrao.service.PersonService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Ignore
@WebMvcTest(PersonRoutingController.class)
public class PersonRoutingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    /**
     * Test for creating a person.
     * @throws Exception
     */
    @Test
    public void testCreatePerson() throws Exception {
        Person person = new Person();
        person.setId("1");
        person.setFirstName("John");
        person.setLastName("Doe");

        // Mock the service to return the created person
        Mockito.when(personService.createPerson(Mockito.any(Person.class))).thenReturn(person != null ? person : new Person());

        mockMvc.perform(post("/sampleJQueryTable/operations")
                        .param("action", "create")
                        .param("id", "1")
                        .param("firstName", "John")
                        .param("lastName", "Doe"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.Result").value("OK"))
                .andExpect(jsonPath("$.Record.firstName").value("John"));
    }

    @Test
    public void testUpdatePerson() throws Exception {

        Mockito.when(personService.updatePerson(Mockito.any(Person.class), Mockito.eq("1"))).thenReturn("Success");


        mockMvc.perform(post("/sampleJQueryTable/operations")
                        .param("action", "update")
                        .param("id", "1")
                        .param("firstName", "John")
                        .param("lastName", "Doe"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.Result").value("OK"));
    }

    @Test
    public void testDeletePerson() throws Exception {
        Mockito.doNothing().when(personService).deletePerson("1");

        mockMvc.perform(post("/sampleJQueryTable/operations")
                        .param("action", "delete")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.Result").value("OK"));
    }

    @Test
    public void testListPersons() throws Exception {
        Person person = new Person();
        person.setId("1");
        person.setFirstName("John");
        person.setLastName("Doe");


        Mockito.when(personService.getPersons()).thenReturn(Arrays.asList(person != null ? person : new Person()));

        mockMvc.perform(post("/sampleJQueryTable/operations")
                        .param("action", "list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.Result").value("OK"))
                .andExpect(jsonPath("$.Records[0].firstName").value("John"));
    }
}