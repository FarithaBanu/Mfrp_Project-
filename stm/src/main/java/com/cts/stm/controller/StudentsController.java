package com.cts.stm.controller;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cts.stm.dao.StudentDao;
import com.cts.stm.dao.StudentsAuthorityDao;
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dto.StudentDTO;
import com.cts.stm.dto.TeacherDTO;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.StudentsAuthoritiesEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.services.inter.StudentAuthoritiesServiceInter;
import com.cts.stm.services.inter.StudentServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentsController {

    @Autowired
    StudentServiceInter studentServiceInter;

    @Autowired
    TeacherServiceInter teacherServiceInter;

    @Autowired
    StudentAuthoritiesServiceInter studentAuthoritiesServiceInter;

    private final String EDIT_ACTION="edit";
    private final String DELETE_ACTION="delete";

    @GetMapping(value = "/main/index")
    public String getAllStudents(Model model){
        System.out.println(CustomController.id+" "+CustomController.type);
        List<StudentDTO> result = studentServiceInter.findAll();
        model.addAttribute("studentList",result);
        return "/main/index";

    }

    @GetMapping(value = "/main/index/actions")
    public String actions(
            @RequestParam(name="action") String act,
            @RequestParam(name="id") Integer id,
            Model model
    ){
        StudentEnt st = studentServiceInter.findById(id);
        if(act.equals(EDIT_ACTION)) {
            List<TeacherDTO> result = teacherServiceInter.findAll();
            model.addAttribute("teachersList",result);
            model.addAttribute("student",st);
            model.addAttribute("teacher",st.getTeacherId().getId());
            return "/edit-operations/edit_student";
        } else if(act.equals(DELETE_ACTION)) {
            System.out.println(id);

            studentAuthoritiesServiceInter.deleteByStudentId(id);
            studentServiceInter.delete(id);

            return "redirect:/main/index";
        } else return "error";
    }

    @PostMapping(value = "/edit-operations/edit_student")
    public String editStudent(
            @ModelAttribute("student") StudentEnt st,@RequestParam("teacher_id") Integer id){
        TeacherEnt tc = teacherServiceInter.findById(id);
        st.setTeacherId(tc);
        studentServiceInter.update(st);
        return "redirect:/main/index";
    }

}
