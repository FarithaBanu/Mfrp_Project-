package com.cts.stm.dao;

import org.springframework.stereotype.Repository;

import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.TeacherEnt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DatabaseDaoImpl implements DatabaseDaoInter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public StudentEnt findByStudentId(Integer id) {
        StudentEnt st = em.find(StudentEnt.class,id);
        return st;
    }

    @Override
    public TeacherEnt findByTeacherId(Integer id) {
        TeacherEnt tc = em.find(TeacherEnt.class,id);
        return tc;
    }

    @Override
    public List<StudentEnt> getAllStudents() {
        Query query = em.createQuery("select s from StudentEnt s");
        return query.getResultList();
    }

    @Override
    public List<TeacherEnt> getAllTeachers() {
        Query query = em.createQuery("select t from TeacherEnt t");
        return query.getResultList();
    }

    @Override
    public List<StudentEnt> getAllStudents(String name, String surname, Integer age) {
        if((name == null || name.isEmpty()) && (surname == null || surname.isEmpty()) && age == null){
            System.out.println("with parametres but they are null");
            return  getAllStudents();
        }
        Query query = em.createQuery("select s from StudentEnt s where s.name = :name and s.surname = :surname and s.age = :age");
        query.setParameter("name",name);
        query.setParameter("surname",surname);
        query.setParameter("age",age);

        return query.getResultList();
    }

    @Override
    public List<TeacherEnt> getAllTeachers(String name, String surname, Integer age) {
        if((name == null || name.isEmpty()) && (surname == null || surname.isEmpty()) && age == null){
            return getAllTeachers();
        }
        Query query = em.createQuery("select t from TeacherEnt t where t.name = :name and t.surname = :surname and t.age = :age");
        query.setParameter("name",name);
        query.setParameter("surname",surname);
        query.setParameter("age",age);

        return query.getResultList();
    }

    @Override
    public boolean saveStudent(StudentEnt st, Integer teacherId) {
        TeacherEnt tc = findByTeacherId(teacherId);
        //StudentEnt st = new StudentEnt(name,surname,age,tc);
        em.persist(st);
        return  true;
    }

    @Override
    public boolean deleteStudent(Integer id) {
        StudentEnt st = findByStudentId(id);
        em.remove(st);
        return true;
    }

    @Override
    public boolean updateStudent(StudentEnt st) {
        em.merge(st);
        return true;
    }

    @Override
    public boolean saveTeacher(TeacherEnt tc) {
        //TeacherEnt tc = new TeacherEnt(name,surname,age,email);
        em.persist(tc);
        return true;
    }

    @Override
    public boolean updateTeacher(TeacherEnt tc) {
        em.merge(tc);
        return true;
    }
}
