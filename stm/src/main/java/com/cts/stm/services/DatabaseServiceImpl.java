package com.cts.stm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.stm.dao.DatabaseDaoInter;
import com.cts.stm.dao.StudentDao;
import com.cts.stm.dao.StudentsAuthorityDao;
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dao.TeachersAuthorityDao;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.StudentsAuthoritiesEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.entities.TeachersAuthoritiesEnt;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DatabaseServiceImpl implements DatabaseServiceInter {

    @Autowired
    DatabaseDaoInter dbdao;
    
    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentsAuthorityDao studentsAuthorityDao;
    
    @Autowired
    TeachersAuthorityDao teachersAuthorityDao;

    @Override
    public StudentEnt findByStudentId(Integer id) {
        return  dbdao.findByStudentId(id);
    }

    @Override
    public TeacherEnt findByTeacherId(Integer id) {
        return dbdao.findByTeacherId(id);
    }

    @Override
    public List<StudentEnt> getAllStudents() {
        return dbdao.getAllStudents();
    }

    @Override
    public List<TeacherEnt> getAllTeachers() {
        return dbdao.getAllTeachers();
    }

    @Override
    public List<StudentEnt> getAllStudents(String name, String surname, Integer age) {
        return dbdao.getAllStudents(name,surname,age);
    }

    @Override
    public List<TeacherEnt> getAllTeachers(String name, String surname, Integer age) {
        return dbdao.getAllTeachers(name,surname,age);
    }

    @Override
    public boolean saveStudent(StudentEnt st, Integer teacherId) {
    	Optional<TeacherEnt> temp = teacherDao.findById(teacherId);
        TeacherEnt teacher = temp.get();
        st.setTeacherId(teacher);

        StudentsAuthoritiesEnt studentsAuthoritiesEnt = new StudentsAuthoritiesEnt();
        studentsAuthoritiesEnt.setStudentid(st);
        studentsAuthoritiesEnt.setAuthority("USER");

        String pass = new BCryptPasswordEncoder().encode(st.getPassword());

        st.setPassword(pass);
        studentsAuthorityDao.save(studentsAuthoritiesEnt);
        return dbdao.saveStudent(st, teacherId);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        return dbdao.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(StudentEnt st) {
        return dbdao.updateStudent(st);
    }

    @Override
    public boolean saveTeacher(TeacherEnt tc) {
    	TeachersAuthoritiesEnt teachersAuthoritiesEnt = new TeachersAuthoritiesEnt();
        teachersAuthoritiesEnt.setAuthority("ADMIN");
        teachersAuthoritiesEnt.setTeacherId(tc);
        String password = new BCryptPasswordEncoder().encode(tc.getPassword());
        tc.setPassword(password);
        teachersAuthorityDao.save(teachersAuthoritiesEnt);
        return dbdao.saveTeacher(tc);
    }

    @Override
    public boolean updateTeacher(TeacherEnt tc) {
        return dbdao.updateTeacher(tc);
    }
}
