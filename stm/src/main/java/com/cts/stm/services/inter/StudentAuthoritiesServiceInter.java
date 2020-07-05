package com.cts.stm.services.inter;

import java.util.List;

import com.cts.stm.entities.StudentsAuthoritiesEnt;

public interface StudentAuthoritiesServiceInter {

    List<StudentsAuthoritiesEnt> findAll();

    StudentsAuthoritiesEnt findByStudentId(Integer id);

    boolean deleteByStudentId(Integer id);
}
