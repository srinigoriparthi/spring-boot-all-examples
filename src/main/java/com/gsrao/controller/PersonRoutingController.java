package com.gsrao.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.gsrao.model.Person;
import com.gsrao.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sampleJQueryTable")
public class PersonRoutingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRoutingController.class);

    @Autowired
    PersonService personService;

    @PostMapping("/operations")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Person> lstUser = new ArrayList<Person>();
        String action = (String) request.getParameter("action");
        System.out.println("Action is:" + action);
        Gson gson = new Gson();
        response.setContentType("application/json");
        if (!StringUtils.isEmpty(action)) {
            if (action.equalsIgnoreCase("list")) {
                List<Person> personList = personService.getPersons();
                LOGGER.info("Invoking Routing for getPersons() Method and Size is:{}", personList.size());
                try {
                    JsonElement element = gson.toJsonTree(personList, new TypeToken<List<Person>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    String listData = jsonArray.toString();
                    //Return Json in the format required by jTable plugin
                    listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                    response.getWriter().print(listData);
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getMessage() + "}";
                    response.getWriter().print(error);
                    ex.printStackTrace();
                }
            } else if (action.equals("create") || action.equals("update")) {
                Person person = new Person();
                if (request.getParameter("id") != null) {
                    person.setId(request.getParameter("id"));
                }
                if (request.getParameter("firstName") != null) {
                    String firstname = (String) request.getParameter("firstName");
                    person.setFirstName(firstname);
                }
                if (request.getParameter("lastName") != null) {
                    String lastname = (String) request.getParameter("lastName");
                    person.setLastName(lastname);
                }
                if (request.getParameter("phone") != null) {
                    String phone = (String) request.getParameter("phone");
                    person.setPhone(phone);
                }
                if (request.getParameter("email") != null) {
                    String email = (String) request.getParameter("email");
                    person.setEmail(email);
                }
                if (request.getParameter("address") != null) {
                    String address = (String) request.getParameter("address");
                    person.setAddress(address);
                }
                try {
                    if (action.equals("create")) {//Create new record
                        Person updatedPer = personService.createPerson(person);
                        lstUser.add(updatedPer);
                        //Convert Java Object to Json
                        String json = gson.toJson(updatedPer);
                        //Return Json in the format required by jTable plugin
                        String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                        response.getWriter().print(listData);
                    } else if (action.equals("update")) {//Update existing record
                        String updateResult = personService.updatePerson(person, person.getId());

                        String listData = "{\"Result\":\"OK\"}";
                        response.getWriter().print(listData);
                    }
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
                    response.getWriter().print(error);
                }
            } else if (action.equals("delete")) {//Delete record
                try {
                    if (request.getParameter("id") != null) {
                        String id = (String) request.getParameter("id");
                        personService.deletePerson(id);
                        String listData = "{\"Result\":\"OK\"}";
                        response.getWriter().print(listData);
                    }
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
                    response.getWriter().print(error);
                }
            }


        }

    }

}
