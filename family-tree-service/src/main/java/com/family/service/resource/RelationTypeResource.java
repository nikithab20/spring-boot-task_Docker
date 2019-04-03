package com.family.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.service.model.RelationType;
import com.family.service.repository.RelationTypeRepository;

@RestController
@RequestMapping("/people/relationships/types")
public class RelationTypeResource {
	
	@Autowired
    private RelationTypeRepository relationTypeRepository;

    @PostMapping
    public RelationType addRelationType(@RequestBody RelationType relationType){
    	try {
    		relationTypeRepository.save(relationType);
    	}catch (Exception e) {
    		System.out.println("Exception occurred"+e.getMessage());
		}
    	return relationTypeRepository.findByRelationName(relationType.getRelationName());
    }
    
}

