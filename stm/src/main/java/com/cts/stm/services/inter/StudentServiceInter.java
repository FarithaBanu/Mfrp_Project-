package com.cts.stm.services.inter;

import java.util.List;

import com.cts.stm.dto.StudentDTO;
import com.cts.stm.entities.StudentEnt;

public interface StudentServiceInter {

    List<StudentDTO> findAll();

    StudentEnt findById(Integer id);

    StudentEnt findByUsername(String username);

    List<StudentDTO> find(String name);

    boolean update(StudentEnt st);

    boolean save(StudentEnt st,Integer id);

    boolean delete(Integer id);


 }
