package com.nisum.test.repository;

import com.nisum.test.model.PersonaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<PersonaInfo, Integer> {

}