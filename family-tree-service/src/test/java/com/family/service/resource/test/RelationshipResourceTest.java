package com.family.service.resource.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.family.service.model.Marriage;
import com.family.service.model.Person;
import com.family.service.model.RelationInfo;
import com.family.service.model.RelationType;
import com.family.service.model.Relations;
import com.family.service.repository.MarriageRepository;
import com.family.service.repository.PersonRepository;
import com.family.service.repository.RelationTypeRepository;
import com.family.service.repository.RelationshipRepository;
import com.family.service.resource.RelationshipResource;

class RelationshipResourceTest {
	
RelationshipRepository relationshipRepository;
	
	MarriageRepository marriageRepository;
	
	RelationTypeRepository relationtypeRepository;
	
	PersonRepository personRepository;
	
	RelationshipResource relationshipResource;
	
	
	@org.junit.jupiter.api.BeforeEach
    public void setup(){
		
		Person person = new Person();
		person.setPersonName("John");
		person.setPersonId(2);
		person.setFatherName("Peter");
		person.setMotherName("Lisa");
		person.setPlaceOfBirth("China");
		
		Person spouse = new Person();
		spouse.setPersonName("Lisa");
		spouse.setPersonId(2);
		spouse.setFatherName("Peter");
		spouse.setMotherName("Ann");
		spouse.setPlaceOfBirth("China");
		
		Person relative = new Person();
		relative.setPersonName("Thomas");
		relative.setPersonId(3);
		relative.setFatherName("Jacob");
		relative.setMotherName("July");
		relative.setPlaceOfBirth("Africa");
		
		
		Marriage marriage = new Marriage();
		marriage.setMarriageId(1);
		marriage.setPerson(person);
		marriage.setSpouse(spouse);
		marriage.setRelation("Marriage");
		
		RelationType relnType=new RelationType();
		relnType.setRelationName("Sister-in-law");
		relnType.setRelnWithSpouse("Sister");
		
		List<HashMap<String, String>> relationShips=new ArrayList<HashMap<String,String>>();
		HashMap<String, String> relationship=new HashMap<String, String>();
		relationship.put("relation_description", "Brother_in_law");
		relationship.put("relation_description", "Cousin");
		relationShips.add(relationship);
		
		List<Relations> relations= new ArrayList<Relations>();
		Relations relation=new Relations();
		relation.setPerson(person);
		relation.setRelation(relnType);
		relation.setRelative(relative);
		relations.add(relation);
				
		
		relationshipRepository = mock(RelationshipRepository.class);
		marriageRepository=mock(MarriageRepository.class);
		relationtypeRepository=mock(RelationTypeRepository.class);
		personRepository=mock(PersonRepository.class);
		
		relationshipResource=new RelationshipResource(relationshipRepository,marriageRepository,relationtypeRepository,personRepository);
		when(marriageRepository.findByPartnerId(any(Integer.class), any(Integer.class))).thenReturn(marriage);
		when(marriageRepository.findByMarriageId(any(Integer.class))).thenReturn(marriage);
		when(relationshipRepository.findRelations(any(Integer.class), any(Integer.class))).thenReturn(relations);
		when(personRepository.findByPersonId(any(Integer.class))).thenReturn(person);
    }

	@org.junit.jupiter.api.Test
	void addRelationTest() {
		RelationInfo marriageInfo=new RelationInfo();
		marriageInfo.setPersonId(1);
		marriageInfo.setSpouseId(2);
		relationshipResource.addRelation(marriageInfo);
		
		RelationInfo relationInfo=new RelationInfo();
		relationInfo.setPersonId(1);
		relationInfo.setRelativeId(3);
		relationInfo.setRelation("Sister");
		relationshipResource.addRelation(relationInfo);
	}
	
	@org.junit.jupiter.api.Test
	void updateRelationTest() {
		RelationInfo marriageInfo=new RelationInfo();
		marriageInfo.setPersonId(1);
		marriageInfo.setSpouseId(2);
		Marriage marriage=relationshipResource.updateRelation(marriageInfo);
	}
	
	@org.junit.jupiter.api.Test
	void getRelationshipsTest() {
		List<HashMap<String, String>> relationShips=relationshipResource.getRelationships(1, 3);
	}
	
	@org.junit.jupiter.api.Test
	void getMarriageRelationshipsTest() {
		Marriage marriage = new Marriage();
		marriage.setMarriageId(1);
		marriage.setPerson(getPerson());
		marriage.setSpouse(getSpouse());
		marriage.setRelation("Divorse");
		when(marriageRepository.findByMarriageId(any(Integer.class))).thenReturn(marriage);
		List<HashMap<String, String>> relationShips=relationshipResource.getRelationships(1, 3);
	}
	
	private Person getPerson(){
		Person person = new Person();
		person.setPersonName("John");
		person.setPersonId(2);
		person.setFatherName("Peter");
		person.setMotherName("Lisa");
		person.setPlaceOfBirth("China");
		return person;
	}
	
	private Person getSpouse(){
		Person spouse = new Person();
		spouse.setPersonName("Lisa");
		spouse.setPersonId(2);
		spouse.setFatherName("Peter");
		spouse.setMotherName("Ann");
		spouse.setPlaceOfBirth("China");
		return spouse;
	}

}
