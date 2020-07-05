package com.cts.stm.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.stm.dao.StudentDao;
import com.cts.stm.dao.StudentsAuthorityDao;
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dto.StudentDTO;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.StudentsAuthoritiesEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.services.inter.StudentServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentServiceInter {

    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentsAuthorityDao studentsAuthorityDao;
    
	/*
	 * @Autowired DatabaseSer
	 */

    @Override
    public List<StudentDTO> findAll() {
     List<StudentEnt> list = studentDao.findAll();  	
    	
        List<StudentDTO> result = new ArrayList<>();

        for(StudentEnt st : list) {
        	result.add(new StudentDTO(st.getId(),st.getName(),st.getSurname(),st.getAge(),st.getScore(),st.getTeacherId().getName(),st.getTeacherId().getSurname()));
        }
		return result;
    }
    @Override
    public StudentEnt findById(Integer id) {
        Optional<StudentEnt> temp = studentDao.findById(id);
        StudentEnt st = temp.get();
        return st;
    }

    @Override
    public StudentEnt findByUsername(String username) {
        return studentDao.findStudentEntByUsername(username);
    }

    @Override
    public List<StudentDTO> find(String name) {

        List<StudentEnt> list = studentDao.findByName(name);
        List<StudentDTO> result = new ArrayList<>();

        for(StudentEnt st : list){
            result.add(new StudentDTO(st.getName(),st.getSurname()));
        }

        return result;
    }

    @Override
    public boolean update(StudentEnt st) {
        studentDao.save(st);
        return true;
    }

    @Override
    public boolean save(StudentEnt st,Integer id){

        Optional<TeacherEnt> temp = teacherDao.findById(id);
        TeacherEnt teacher = temp.get();
        st.setTeacherId(teacher);

        StudentsAuthoritiesEnt studentsAuthoritiesEnt = new StudentsAuthoritiesEnt();
        studentsAuthoritiesEnt.setStudentid(st);
        studentsAuthoritiesEnt.setAuthority("USER");

        String pass = new BCryptPasswordEncoder().encode(st.getPassword());

        st.setPassword(pass);

        studentDao.save(st);
        studentsAuthorityDao.save(studentsAuthoritiesEnt);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        studentDao.deleteById(id);
        return true;
    }
    

}
