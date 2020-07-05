package com.cts.stm.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.stm.entities.TeachersAuthoritiesEnt;

public interface TeachersAuthorityDao extends CrudRepository<TeachersAuthoritiesEnt,Integer> {

    TeachersAuthoritiesEnt findByTeacherIdId(Integer id);
}
