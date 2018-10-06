package com.test.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.dao.PersonRepository;
import com.test.entity.Person;

@RestController
@RequestMapping(value = "/api/person")
@CrossOrigin(origins = "*")
public class PersonRestController {

	public static Logger LOGGER = LoggerFactory.getLogger(PersonRestController.class);

	@Autowired
	private PersonRepository personRepository;

	@GetMapping(value = "/find")
	public ResponseEntity<Person> getPersonById(@RequestParam Long id) {
		try {
			return new ResponseEntity<Person>(personRepository.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Fail  to get person with id --{}{}", id, e);
			return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<Person>> getAllPerson() {
		try {
			return new ResponseEntity<List<Person>>((List<Person>) personRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("fail to get list person --{}{}", e);
			return new ResponseEntity<List<Person>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<Person> savePerson(@RequestBody Person person, BindingResult result) {
		try {
			if (!result.hasErrors()) {
				personRepository.save(person);
				return new ResponseEntity<Person>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOGGER.error("Fail to update person with id --{}{}", person.getId(), e);
			return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person, BindingResult result) {
		try {
			if (!result.hasErrors()) {
				personRepository.save(person);
				return new ResponseEntity<Person>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOGGER.error("Fail to update person with id --{}{}", person.getId(), e);
			return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Person> deletePerson(@RequestParam Long id) {
		try {
			Person person = new Person();
			person.setId(id);
			personRepository.delete(person);
			return new ResponseEntity<Person>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Fail delete person with id --{}{}", id, e);
			return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
