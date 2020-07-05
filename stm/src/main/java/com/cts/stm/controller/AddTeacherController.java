package com.cts.stm.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dao.TeachersAuthorityDao;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.entities.TeachersAuthoritiesEnt;
import com.cts.stm.services.DatabaseServiceInter;
import com.cts.stm.services.inter.TeacherAuthoritiesServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

@Controller
public class AddTeacherController {

    @Autowired
    TeacherServiceInter teacherServiceInter;
    
    @Autowired
    DatabaseServiceInter dataBaseServiceInter;

    @GetMapping(value = "/add-operations/add_teacher")
    public String add_teacher_main(Model model){
        TeacherEnt teacherEnt = new TeacherEnt();
        model.addAttribute("teacher",teacherEnt);
        return "/add-operations/add_teacher";
    }

    @PostMapping(value = "/add-operations/add_teacher/add")
    public String add_teacher_add(@ModelAttribute("teacher") TeacherEnt tc){
    	dataBaseServiceInter.saveTeacher(tc);
        return "redirect:/main/teachers";
    }
}
