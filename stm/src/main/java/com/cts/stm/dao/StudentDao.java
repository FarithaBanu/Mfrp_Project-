package com.cts.stm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cts.stm.dto.StudentDTO;
import com.cts.stm.entities.*;

import java.util.List;

public interface StudentDao extends CrudRepository<StudentEnt,Integer> {

    StudentEnt findStudentEntByUsername(String username);


    @Query("select s from StudentEnt as s left join TeacherEnt as t on s.teacher_id.id = t.id")
    List<StudentEnt> findAll();

    List<StudentEnt> findByName(String name);

}
