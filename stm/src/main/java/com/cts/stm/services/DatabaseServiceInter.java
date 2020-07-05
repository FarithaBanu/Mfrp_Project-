package com.cts.stm.services;

import java.util.List;

import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.TeacherEnt;

public interface DatabaseServiceInter {

    StudentEnt findByStudentId(Integer id);

    TeacherEnt findByTeacherId(Integer id);

    List<StudentEnt> getAllStudents();

    List<TeacherEnt> getAllTeachers();

    List<StudentEnt> getAllStudents(String name,String surname,Integer age);

    List<TeacherEnt> getAllTeachers(String name,String surname,Integer age);

    boolean saveStudent(StudentEnt st,Integer teacherId);

    boolean deleteStudent(Integer id);

    boolean updateStudent(StudentEnt st);

    boolean saveTeacher(TeacherEnt tc);

    boolean updateTeacher(TeacherEnt tc);

}
