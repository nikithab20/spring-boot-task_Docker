package com.family.service.resource.test;

import static org.mockito.Mockito.mock;

import com.family.service.model.RelationType;
import com.family.service.repository.RelationTypeRepository;
import com.family.service.resource.RelationTypeResource;

class RelationTypeResourceTest {
	
	RelationTypeRepository relationtypeRepository;
	RelationTypeResource relationtypeResource;
	
	@org.junit.jupiter.api.BeforeEach
    public void setup(){
		relationtypeRepository=mock(RelationTypeRepository.class);
		relationtypeResource=new RelationTypeResource(relationtypeRepository);
    }

	@org.junit.jupiter.api.Test
	void addRelationTypeTest() {
		RelationType relationType=new RelationType();
		relationType.setRelationName("Sister-in-law");
		relationType.setRelnWithSpouse("Sister");
		relationtypeResource.addRelationType(relationType);
	}
	
	

}
