package com.family.service.resource.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.family.service.model.Person;
import com.family.service.repository.PersonRepository;
import com.family.service.resource.PersonResource;

class PersonResourceTest {

	PersonRepository personRepository;
	
	PersonResource personResource;

	@org.junit.jupiter.api.BeforeEach
    public void setup(){
		Person person1 = new Person();
		person1.setPersonName("Alex");
		person1.setPersonId(1);
		person1.setFatherName("James");
		person1.setMotherName("Ann");
		person1.setPlaceOfBirth("Berlin");
		
		Person person2 = new Person();
		person2.setPersonName("Rian");
		person2.setPersonId(2);
		person2.setFatherName("Peter");
		person2.setMotherName("Lisa");
		person2.setPlaceOfBirth("China");
		
		List<Person> people=new ArrayList<Person>();
		people.add(person1);
		people.add(person2);
		
		personRepository = mock(PersonRepository.class);
		personResource=new PersonResource(personRepository);
		when(personResource.getPersonById(any(Integer.class))).thenReturn(person1);
		when(personResource.getPersonsByName(any(String.class))).thenReturn(people);
    }

	@org.junit.jupiter.api.Test
	public void getPersonByNameTest() {
		List<Person> people= personResource.getPersonsByName("Alex");
		assertEquals(people.get(0).getPersonName(), "Alex");
	}
	
	@org.junit.jupiter.api.Test
	public void getPersonByIdTest() {
		Person people= personResource.getPersonById(2);
		assertEquals(people.getPersonId().toString(), "1");
		assertEquals(people.getPersonName(), "Alex");
		
	}
	
	@org.junit.jupiter.api.Test
	public void addPersonTest() {
		Person people= personResource.addPerson(getPerson());
		assertEquals(people.getPersonId().toString(), "1");
		assertEquals(people.getPersonName(), "Alex");
		
	}
	
	private Person getPerson(){
		Person person = new Person();
		person.setPersonName("Alex");
		person.setPersonId(1);
		person.setFatherName("James");
		person.setMotherName("Ann");
		person.setPlaceOfBirth("Berlin");
		return person;
	}

}
