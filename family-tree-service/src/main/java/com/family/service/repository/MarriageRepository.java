package com.family.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.family.service.model.Marriage;

public interface MarriageRepository extends JpaRepository<Marriage, Integer> {
      Marriage findByMarriageId(Integer marriageId);
      @Query("select m from Marriage m where (m.person.personId=?1 AND m.spouse.personId=?2) OR (m.person.personId=?2 AND m.spouse.personId=?1)")
      Marriage findByPartnerId(Integer person,Integer spouse);
}
