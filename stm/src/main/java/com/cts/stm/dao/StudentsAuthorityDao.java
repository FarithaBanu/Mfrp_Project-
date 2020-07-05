package com.cts.stm.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.stm.entities.StudentsAuthoritiesEnt;

public interface StudentsAuthorityDao extends CrudRepository<StudentsAuthoritiesEnt,Integer> {

    void deleteByStudentidId(Integer id);

    StudentsAuthoritiesEnt findByStudentidId(Integer id);

}
