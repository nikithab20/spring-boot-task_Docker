package com.family.service.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.family.service.model.Person;
import com.family.service.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonResource {

    
	@Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Person getPersonById(@PathVariable Integer id) {
    	Person person=null;
    	try {
    		person = personRepository.findByPersonId(id);
    		//person.addLinks("", "self");
    	}catch(Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
    	}
    	 return person;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersonsByName(@RequestParam(value="name") String personName) {
    	List<Person> peoples=new ArrayList<Person>();
    	try {
    		peoples=personRepository.findByPersonName(personName);
    	}catch(Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
    	}
    	return peoples;
    }
   
    @PostMapping
    public Person addPerson(@RequestBody final Person person) {
    	try {
    		personRepository.save(person);
    		return getPersonById(person.getPersonId());
    	}catch(Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
    	}
		return null;
    }

}
