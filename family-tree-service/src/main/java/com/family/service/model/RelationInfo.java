package com.family.service.model;

public class RelationInfo {
	
	private Integer personId;
	private Integer spouseId;
	private Integer relativeId;
	private Integer marriageId;
	private String relation;
	private String relation_description;
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Integer getSpouseId() {
		return spouseId;
	}
	public void setSpouseId(Integer spouseId) {
		this.spouseId = spouseId;
	}
	public Integer getRelativeId() {
		return relativeId;
	}
	public void setRelativeId(Integer relativeId) {
		this.relativeId = relativeId;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public Integer getMarriageId() {
		return marriageId;
	}
	public void setMarriageId(Integer marriageId) {
		this.marriageId = marriageId;
	}
	public String getRelation_description() {
		return relation_description;
	}
	public void setRelation_description(String relation_description) {
		this.relation_description = relation_description;
	}

}
