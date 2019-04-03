package com.family.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.family.service.model.RelationType;

public interface RelationTypeRepository extends JpaRepository<RelationType, Integer> {
		RelationType findByRelationName(String relationName);
}
