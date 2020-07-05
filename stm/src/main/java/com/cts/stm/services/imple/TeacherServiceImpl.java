package com.cts.stm.services.imple;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dao.TeachersAuthorityDao;
import com.cts.stm.dto.StudentDTO;
import com.cts.stm.dto.TeacherDTO;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.entities.TeachersAuthoritiesEnt;
import com.cts.stm.services.inter.TeacherAuthoritiesServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherServiceInter {

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    TeachersAuthorityDao teachersAuthorityDao;

    @Override
    public List<TeacherDTO> findAll() {
        Iterable it = teacherDao.findAll();
        List<TeacherEnt> temp = IteratorUtils.toList(it.iterator());
        List<TeacherDTO> result = new ArrayList<>();

        for(TeacherEnt tc : temp){
            result.add(new TeacherDTO(tc.getId(),tc.getName(),tc.getSurname(),tc.getAge(),tc.getEmail(),tc.getStudentEntList().size()));
        }

        return result;
    }

    @Override
    public List<TeacherDTO> find(String name) {
        List<TeacherEnt> list = teacherDao.findByName(name);
        List<TeacherDTO> result = new ArrayList<>();

        for(TeacherEnt tc : list){
            result.add(new TeacherDTO(tc.getName(),tc.getSurname()));
        }
        return result;
    }

    @Override
    public TeacherEnt findById(Integer id) {
        Optional<TeacherEnt> temp = teacherDao.findById(id);
        TeacherEnt teacher = temp.get();
        return teacher;
    }

    @Override
    public boolean save(TeacherEnt tc) {
        TeachersAuthoritiesEnt teachersAuthoritiesEnt = new TeachersAuthoritiesEnt();
        teachersAuthoritiesEnt.setAuthority("ADMIN");
        teachersAuthoritiesEnt.setTeacherId(tc);
        String password = new BCryptPasswordEncoder().encode(tc.getPassword());
        tc.setPassword(password);
        teacherDao.save(tc);
        teachersAuthorityDao.save(teachersAuthoritiesEnt);
        return true;
    }

    @Override
    public boolean update(TeacherEnt tc) {
        teacherDao.save(tc);
        return false;
    }

}
