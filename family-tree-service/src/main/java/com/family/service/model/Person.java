package com.family.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.family.service.helper.DateHandler;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "people",catalog = "test")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;
    
    @Column(name = "person_name")
    private String personName;
    
    @Column(name = "father_name")
    private String fatherName;
    
    @Column(name = "mother_name")
    private String motherName;
    
    @Column(name = "birth_place")
    private String placeOfBirth;
    
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = DateHandler.class)
	private Date dateOfBirth;
    

    public Person() {}

    public Person(String personName, String fatherName, String motherName, String placeOfBirth, Date dateOfBirth) {
    	this.personName = personName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.placeOfBirth = placeOfBirth;
		this.dateOfBirth = dateOfBirth;

    }

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
