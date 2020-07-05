package com.cts.stm.services.inter;

import com.cts.stm.entities.TeachersAuthoritiesEnt;

public interface TeacherAuthoritiesServiceInter {

    TeachersAuthoritiesEnt findByTeacherId(Integer id);
}
