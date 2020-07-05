package com.cts.stm.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.stm.dao.StudentsAuthorityDao;
import com.cts.stm.entities.StudentsAuthoritiesEnt;
import com.cts.stm.services.inter.StudentAuthoritiesServiceInter;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentAuthoritiesServiceImpl implements StudentAuthoritiesServiceInter {

    @Autowired
    StudentsAuthorityDao studentsAuthorityDao;

    @Override
    public List<StudentsAuthoritiesEnt> findAll() {
        return null;
    }

    @Override
    public StudentsAuthoritiesEnt findByStudentId(Integer id) {
        return studentsAuthorityDao.findByStudentidId(id);
    }

    @Override
    public boolean deleteByStudentId(Integer id) {
        studentsAuthorityDao.deleteByStudentidId(id);
        return true;
    }


}
