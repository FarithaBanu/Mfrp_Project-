package com.cts.stm.controller;


import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.stm.dao.StudentDao;
import com.cts.stm.dao.StudentsAuthorityDao;
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dto.TeacherDTO;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.StudentsAuthoritiesEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.services.DatabaseServiceInter;
import com.cts.stm.services.inter.StudentAuthoritiesServiceInter;
import com.cts.stm.services.inter.StudentServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AddStudentController {

    @Autowired
    StudentServiceInter studentServiceInter;

    @Autowired
    TeacherServiceInter teacherServiceInter;

    @Autowired
    StudentAuthoritiesServiceInter studentAuthoritiesServiceInter;
    
    @Autowired
    DatabaseServiceInter dataBaseServiceInter;

    @GetMapping(value = "/add-operations/add_student")
    public String add_student_main(Model model){

        StudentEnt st = new StudentEnt();
        List<TeacherDTO> list = teacherServiceInter.findAll();

        model.addAttribute("teachersList",list);
        model.addAttribute("student",st);
        return "/add-operations/add_student";
    }

    @PostMapping(value = "/add-operations/add_student/add")
    public String add_student_add(@ModelAttribute(name = "student") StudentEnt st, @RequestParam(name="teacher_id") Integer id){

    	dataBaseServiceInter.saveStudent(st, id);

        return "redirect:/main/index";
    }
}
