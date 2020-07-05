package com.cts.stm.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.stm.dao.TeachersAuthorityDao;
import com.cts.stm.entities.TeachersAuthoritiesEnt;
import com.cts.stm.services.inter.TeacherAuthoritiesServiceInter;

@Service
public class TeacherAuthoritiesServiceImpl implements TeacherAuthoritiesServiceInter {

    @Autowired
    TeachersAuthorityDao teachersAuthorityDao;

    @Override
    public TeachersAuthoritiesEnt findByTeacherId(Integer id) {
        return teachersAuthorityDao.findByTeacherIdId(id);
    }
}
