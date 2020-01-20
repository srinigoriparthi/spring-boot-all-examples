package com.gsrao.controller;

import com.gsrao.dao.PersonRepository;
import com.gsrao.exception.ResourceNotFoundException;
import com.gsrao.model.Person;
import com.gsrao.service.PersonService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
//@RequestMapping("/api/v1")
@Api(value = "Person Management System", description = "Operations pertaining to person in Person Management System")
@Slf4j
public class PersonRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRestController.class);

    @Autowired
    PersonService personService;

  /*  @RequestMapping(path="/", method= RequestMethod.GET)
    public String goHome(){
        return "index";
    }*/

    @ApiOperation(value = "Add an Person")
    @PostMapping("/createperson")
    public ResponseEntity<Person> createPerson(
            @ApiParam(value = "Person object store in database Table", required = true)
            @Valid@RequestBody Person person)
    {
        LOGGER.info("Before Creation !!");
        Person result =  personService.createPerson(person);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new ResponseEntity<Person>(result, headers, HttpStatus.OK);
    }

    /**
     * UPDATE Operation
     * @param person Person
     * @param id int
     * @return ResponseEntity<String>
     */
    @ApiOperation(value = "Updating person")
    @PutMapping("/updateperson/{id}")
    public ResponseEntity<String> updatePerson(
            @ApiParam(value = "Update Person Object", required = true)
            @Valid @RequestBody Person person,
            @ApiParam(value = "Person Id to Update", required = true)
            @Valid @PathVariable String id){
        String result = personService.updatePerson(person,id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new ResponseEntity<String>(result, headers, HttpStatus.OK);
    }

    /**
     * GET Operation   https://localhost:9095/api/v1/persons/1
     * @param id String
     * @return Person
     */
    @ApiOperation(value = "Person update in Data base Table")
    //@GetMapping("/getperson/{id}")
    @RequestMapping(value = "/getperson/{id}", produces = "application/json", method=RequestMethod.GET)
    public ResponseEntity<Person> getPerson(
            @ApiParam(value = "Person object Update in database Table", required = true)
            @Valid
            @PathVariable(value = "id") String id) throws ResourceNotFoundException{
        Person person = personService.getPerson(id);
        if(null == person){
            throw new ResourceNotFoundException(id);
        }
        return ResponseEntity.ok().body(person);
    }

    /**
     * Retrieving and returning list of all registered Persons.
     * https://localhost:9095/api/v1/persons
     * @return List<Person>
     */
    @ApiOperation(value = "View the List of all Persons", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    //@GetMapping("/getpersons")
    @RequestMapping(path = "/getpersons", produces = { "application/json", "application/xml" }, method=RequestMethod.GET)
    public List<Person> getPersons(){
        LOGGER.info("Invoking for getPersons() Method !!");
        List<Person> personList = personService.getPersons();
        LOGGER.info("Invoking for getPersons() Method and Size is:{}",personList.size());
        return personList;

    }



    /**
     * DELETE Operation
     * @param id int
     * @return
     */
    @ApiOperation(value = "Deleting Person")
    //@DeleteMapping ("/delperson/{id}")
    @RequestMapping(value = "/delperson/{id}", produces = "application/json", method=RequestMethod.DELETE)
    public ResponseEntity<String> deletePerson(
            @ApiParam(value = "Person Id to Delete", required = true) @Valid
            @PathVariable String id){

        personService.deletePerson(id);
        return new ResponseEntity<String>("Person "+id+" Deleted Successfully !!",HttpStatus.OK);
    }

}
