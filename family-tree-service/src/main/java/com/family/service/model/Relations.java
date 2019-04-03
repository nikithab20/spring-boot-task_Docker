package com.family.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relations",catalog = "test")
public class Relations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer relationId;

    @ManyToOne(cascade=CascadeType.ALL)
    private Person person;

    @ManyToOne(cascade=CascadeType.ALL)
    private Person relative;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private RelationType relation;
    

    public Relations() {}

    public Relations(Person person,Person relative,RelationType relationType) {
        this.person = person;
        this.relative = relative;
        this.relation = relationType;
    }
    
	public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getRelative() {
		return relative;
	}

	public void setRelative(Person relative) {
		this.relative = relative;
	}

	public RelationType getRelation() {
		return relation;
	}

	public void setRelation(RelationType relation) {
		this.relation = relation;
	}

}
