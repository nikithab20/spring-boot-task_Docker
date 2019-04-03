package com.family.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relation_types",catalog = "test")
public class RelationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer relationTypeId;

    @Column(name = "relation_name",unique=true)
    private String relationName;

    @Column(name = "sex_criteria")
    private String sexCriteria;
    
    @Column(name = "age_criteria")
    private Integer ageCriteria;
    
    @Column(name = "reln_with_parent")
    private String relnWithParent;
    
    @Column(name = "reln_with_spouse")
    private String relnWithSpouse;
    
    @Column(name = "reln_with_child")
    private String relnWithChild;
    
    public RelationType() {}

	public RelationType(String relationName, String sexCriteria, Integer ageCriteria, String relnWithParent, String relnWithSpouse,
			String relnWithChild) {
		this.relationName = relationName;
		this.sexCriteria = sexCriteria;
		this.ageCriteria = ageCriteria;
		this.relnWithParent = relnWithParent;
		this.relnWithSpouse = relnWithSpouse;
		this.relnWithChild = relnWithChild;
	}

	public Integer getRelationTypeId() {
		return relationTypeId;
	}

	public void setRelationTypeId(Integer relationTypeId) {
		this.relationTypeId = relationTypeId;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getSexCriteria() {
		return sexCriteria;
	}

	public void setSexCriteria(String sexCriteria) {
		this.sexCriteria = sexCriteria;
	}

	public Integer getAgeCriteria() {
		return ageCriteria;
	}

	public void setAgeCriteria(Integer ageCriteria) {
		this.ageCriteria = ageCriteria;
	}

	public String getRelnWithParent() {
		return relnWithParent;
	}

	public void setRelnWithParent(String relnWithParent) {
		this.relnWithParent = relnWithParent;
	}

	public String getRelnWithSpouse() {
		return relnWithSpouse;
	}

	public void setRelnWithSpouse(String relnWithSpouse) {
		this.relnWithSpouse = relnWithSpouse;
	}

	public String getRelnWithChild() {
		return relnWithChild;
	}

	public void setRelnWithChild(String relnWithChild) {
		this.relnWithChild = relnWithChild;
	}
    
}
