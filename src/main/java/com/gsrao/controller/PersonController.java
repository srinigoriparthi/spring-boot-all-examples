package com.gsrao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/**
 * PersonController
 */
public class PersonController {
	
	@RequestMapping(path="/", method= RequestMethod.GET)
	public String goHome(){
		return "index";
	}

}
