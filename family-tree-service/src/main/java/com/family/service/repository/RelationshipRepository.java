package com.family.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.family.service.model.Relations;

public interface RelationshipRepository extends JpaRepository<Relations, Integer> {
		@Query("select r from Relations r where (r.person.personId=?1 AND r.relative.personId=?2) OR (r.relative.personId=?2 AND r.relative.personId=?1)")
		List<Relations> findRelations(Integer personId,Integer spouseId);
}
