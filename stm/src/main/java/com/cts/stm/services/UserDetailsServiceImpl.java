package com.cts.stm.services;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.stm.controller.CustomController;
import com.cts.stm.dao.StudentDao;
import com.cts.stm.dao.StudentsAuthorityDao;
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dao.TeachersAuthorityDao;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.StudentsAuthoritiesEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.entities.TeachersAuthoritiesEnt;
import com.cts.stm.services.inter.StudentAuthoritiesServiceInter;
import com.cts.stm.services.inter.StudentServiceInter;
import com.cts.stm.services.inter.TeacherAuthoritiesServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    StudentServiceInter studentServiceInter;

    @Autowired
    TeacherServiceInter teacherServiceInter;

    @Autowired
    StudentAuthoritiesServiceInter studentAuthoritiesServiceInter;

    @Autowired
    TeacherAuthoritiesServiceInter teacherAuthoritiesServiceInter;

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentsAuthorityDao studentsAuthorityDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    TeachersAuthorityDao teachersAuthorityDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       StudentEnt st = studentServiceInter.findByUsername(username);
        
       User.UserBuilder userBuilder = null;

        if(st!=null){

            userBuilder = User.withUsername(username);
           // userBuilder.password(new BCryptPasswordEncoder().encode(st.getPassword()));

            userBuilder.password(st.getPassword());
            Integer id = st.getId();
            CustomController.id= id;
            CustomController.type = "student";

            if(isUser(id)){
                userBuilder.authorities("USER");
            } // else throw no auth

        } else {
            TeacherEnt tc = teacherDao.findTeacherEntByUsername(username);

            if (tc!=null){

                userBuilder = User.withUsername(username);
                userBuilder.password(tc.getPassword());

                Integer id = tc.getId();
                CustomController.id = id;
                CustomController.type = "teacher";

                if(isAdmin(id)){
                    userBuilder.authorities("ADMIN");
                }
            }else{
                throw new UsernameNotFoundException("User not found.");
            }

        }

        return userBuilder.build();
    }

    private boolean isUser(Integer id){

        if(studentAuthoritiesServiceInter.findByStudentId(id)!=null){
            return  true;
        }

        return  false;
    }

    private boolean isAdmin(Integer id){

        if(teacherAuthoritiesServiceInter.findByTeacherId(id)!=null){
            return true;
        }

        return  false;
    }
}
