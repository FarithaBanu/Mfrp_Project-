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
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dto.TeacherDTO;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class TeachersController {

    public final String EDIT_ACTION = "edit";

    @Autowired
    TeacherServiceInter teacherServiceInter;

    @GetMapping(value = "/main/teachers")
    public String getAllTeachers(Model model){

        List<TeacherDTO> result = teacherServiceInter.findAll();

        model.addAttribute("teachersList",result);
        return "/main/teachers";
    }

    @GetMapping(value = "/main/teachers/actions")
    public String actions(
            @RequestParam(name="action") String act,
            @RequestParam(name="id") Integer id,
            Model model
    ){
        if(act.equals(EDIT_ACTION)){
            TeacherEnt tc = teacherServiceInter.findById(id);
            model.addAttribute("teacher",tc);
            return "/edit-operations/edit_teacher";
        } else return "redirect:/error";
    }

    @PostMapping(value = "/edit-operations/edit_teacher")
    public String editTeacher(@ModelAttribute(name = "teacher") TeacherEnt tc){
        teacherServiceInter.update(tc);
        return "redirect:/main/teachers";
    }
}
