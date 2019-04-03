package com.family.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marriages",catalog = "test")
public class Marriage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer marriageId;

    @ManyToOne(cascade=CascadeType.ALL)
    private Person person;


    @ManyToOne(cascade=CascadeType.ALL)
    private Person spouse;
    
    @Column(name = "relation")
    private String relation;

    public Marriage() {}

    public Marriage(Person person,Person spouse,String relation) {
        this.person = person;
        this.spouse = spouse;
        this.relation = relation;
    }
    
    public Integer getMarriageId() {
		return marriageId;
	}

	public void setMarriageId(Integer marriageId) {
		this.marriageId = marriageId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
    public String toString() {
        return "Marriage{" +
                "marriageId=" + marriageId +
                ", person=" + person +
                ", spouse=" + spouse +
                ", relation=" + relation +
                '}';
    }

}
