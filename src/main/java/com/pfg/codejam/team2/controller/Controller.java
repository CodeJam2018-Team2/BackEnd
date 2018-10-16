package com.pfg.codejam.team2.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

	private static final Logger LOG = Logger.getLogger(Controller.class);

	@RequestMapping(value="/request", method = RequestMethod.POST)
	public ResponseEntity<String> getData(@RequestParam("id") long id) {

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
