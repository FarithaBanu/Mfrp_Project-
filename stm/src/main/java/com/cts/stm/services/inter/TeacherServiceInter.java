package com.cts.stm.services.inter;

import java.util.List;

import com.cts.stm.dto.TeacherDTO;
import com.cts.stm.entities.TeacherEnt;

public interface TeacherServiceInter {

    List<TeacherDTO> findAll();

    List<TeacherDTO> find(String name);

    TeacherEnt findById(Integer id);

    boolean save(TeacherEnt tc);

    boolean update(TeacherEnt tc);

}
