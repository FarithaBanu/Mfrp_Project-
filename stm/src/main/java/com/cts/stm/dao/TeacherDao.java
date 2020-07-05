package com.cts.stm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cts.stm.entities.TeacherEnt;

import java.util.List;

public interface TeacherDao extends CrudRepository<TeacherEnt,Integer> {

    TeacherEnt findTeacherEntByUsername(String username);

    List<TeacherEnt> findByName(String name);
}
