package com.family.service.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.family.service.exception.DataNotFoundException;
import com.family.service.model.Marriage;
import com.family.service.model.Person;
import com.family.service.model.RelationInfo;
import com.family.service.model.RelationType;
import com.family.service.model.Relations;
import com.family.service.repository.MarriageRepository;
import com.family.service.repository.PersonRepository;
import com.family.service.repository.RelationTypeRepository;
import com.family.service.repository.RelationshipRepository;

@RestController
@RequestMapping("/people/relationships")
public class RelationshipResource {
	
	@Autowired
    private PersonRepository personRepository;
	
	@Autowired
    private MarriageRepository marriageRepository;
	
	@Autowired
    private RelationTypeRepository relationTypeRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;
    
    @PostMapping
    public ResponseEntity<Void> addRelation(@RequestBody RelationInfo relationInfo,UriComponentsBuilder ucBuilder){
    	HttpHeaders headers = new HttpHeaders();
    	try {
    		if(null!=relationInfo.getSpouseId()) {
        		Marriage marriage=new Marriage();
        		Person person=personRepository.findByPersonId(relationInfo.getPersonId());
        		Person spouse=personRepository.findByPersonId(relationInfo.getSpouseId());
        		if(null==person || null==spouse) {
        			throw new DataNotFoundException("Person or Spouse doesnt exist in the people DB.Add people details first ");
        		}
        		marriage.setPerson(personRepository.findByPersonId(relationInfo.getPersonId()));
            	marriage.setSpouse(personRepository.findByPersonId(relationInfo.getSpouseId()));
            	marriage.setRelation("Marriage");
            	marriageRepository.save(marriage);
            	headers.setLocation(ucBuilder.path("/people/relationships/{id}").buildAndExpand(marriage.getMarriageId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        	}else {
        		Relations relation=new Relations();
        		Person person=personRepository.findByPersonId(relationInfo.getPersonId());
        		Person relative=personRepository.findByPersonId(relationInfo.getRelativeId());
        		if(null==person || null==relative) {
        			throw new DataNotFoundException("Person or Relative doesnt exist in the people DB.Add people details first ");
        		}
        		relation.setPerson(person);
        		relation.setRelative(relative);
        		RelationType relnType=relationTypeRepository.findByRelationName(relationInfo.getRelation());
        		if(null==relnType) {
        			relnType=new RelationType();
            		relnType.setRelationName(relationInfo.getRelation());
            		relationTypeRepository.save(relnType);
        		}
        		relation.setRelation(relnType);
        		relationshipRepository.save(relation);
        		
                headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(relation.getRelationId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        	}
    		
    	}catch (Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    	
    }
    
    @PutMapping
    public Marriage updateRelation(@RequestBody RelationInfo personId) {
    	Marriage marriage=new Marriage();
    	try {
    		marriage=marriageRepository.findByPartnerId(personId.getPersonId(),personId.getSpouseId());
    		if(null==marriage) {
    			throw new DataNotFoundException("Marriage relationship doesnt exist between"+personId.getPersonId()+" and"+personId.getSpouseId());
    		}
        	marriage.setRelation("Divorse");
        	marriageRepository.save(marriage);
        	marriage= marriageRepository.findByMarriageId(marriage.getMarriageId());
    	}catch(Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
    	}
    	return marriage;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<HashMap<String, String>> getRelationships(@RequestParam(value="person") Integer personId,@RequestParam(value="relative") Integer relativeId) {
    	ArrayList<HashMap<String, String>> relnDescription=new ArrayList<HashMap<String, String>>();
    	Marriage marriage=new Marriage();
    	try {
    		marriage=marriageRepository.findByPartnerId(personId,relativeId);
        	if(null!=marriage && marriage.getRelation()=="Marriage") {
        		HashMap<String, String> relations=new HashMap<String, String>();
        		relations.put("marriage_Id", marriage.getMarriageId().toString());
        		relations.put("relation_description", marriage.getRelation());
    			relnDescription.add(relations);
        	}else {
        		List<Relations> relationsList=relationshipRepository.findRelations(personId,relativeId);
            	for (Relations relation : relationsList) {
            		HashMap<String, String> relations=new HashMap<String, String>();
            		relations.put("relation_description", relation.getRelation().getRelationName());
        			relnDescription.add(relations);
        		}
        	}
        	
    	}catch(Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
    	}
    	return relnDescription;
    }
    
}

