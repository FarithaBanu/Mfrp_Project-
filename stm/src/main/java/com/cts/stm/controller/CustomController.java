package com.cts.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cts.stm.dao.StudentDao;
import com.cts.stm.dao.TeacherDao;
import com.cts.stm.dto.StudentDTO;
import com.cts.stm.dto.TeacherDTO;
import com.cts.stm.entities.StudentEnt;
import com.cts.stm.entities.TeacherEnt;
import com.cts.stm.services.inter.StudentServiceInter;
import com.cts.stm.services.inter.TeacherServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomController {

    @Autowired
    StudentServiceInter studentServiceInter;

    @Autowired
    TeacherServiceInter teacherServiceInter;

    public static Integer id = null;
    public static String type = null;
    public boolean bad = false;

    @GetMapping(value = "/menu")
    public String menu_student(@RequestParam(name = "menu") String mn) {
        switch (mn) {
            case "students":
                return "redirect:/main/index"; //student page as index page
            case "teachers":
                return "redirect:/main/teachers";
            case "adds":
                return "redirect:/add-operations/add_student";
            case "addt":
                return "redirect:/add-operations/add_teacher";
            case "logout":
            	 return "redirect:/logout_page";
            case "edit_profile":
                return "redirect:/edit-operations/edit_profile";
            default:
                return "redirect:/error";
        }
    }

    
    @GetMapping(value = "/logout_page")
    public String logout_page() {
        return "logout_page";
    }
  
    @GetMapping(value = "/access_denied")
    public String access_denied() {
        return "access_denied";
    }
    
    

    @GetMapping(value = "/edit-operations/edit_profile")
    public String edit_profile(Model model) {
        if (type.equals("student")) {
            StudentEnt st = studentServiceInter.findById(id);
            model.addAttribute("path", "student");
            model.addAttribute("type", st);
        } else {
            TeacherEnt tc = teacherServiceInter.findById(id);
            model.addAttribute("path", "teacher");
            model.addAttribute("type", tc);
        }

        if (bad) model.addAttribute("bad", "\"New password\" is not equals \"Confirm new password\". Please check it.");

        bad = false;
        return "/edit-operations/edit_profile";
    }

    @PostMapping(value = "/edit-operations/edit_profile/{type}")
    public String edit_profile_save(
            @PathVariable("type") String type,
            @RequestParam("username") String username,
            @RequestParam("newpassword") String newPassword,
            @RequestParam("confirmnewpassword") String confirmNewPassword,
            @RequestParam("id") Integer ID) {
        if (type.equals("student")) {
            StudentEnt studentEnt = studentServiceInter.findById(ID);

            if (newPassword.equals(confirmNewPassword)) {

                studentEnt.setUsername(username);
                studentEnt.setPassword(bytePassword(newPassword));

                studentServiceInter.update(studentEnt);

            } else {
                bad = true;
                return "redirect:/edit-operations/edit_profile";
            }
        } else {
            TeacherEnt teacherEnt = teacherServiceInter.findById(ID);

            if (newPassword.equals(confirmNewPassword)) {
                teacherEnt.setUsername(username);
                teacherEnt.setPassword(bytePassword(newPassword));

                teacherServiceInter.update(teacherEnt);
            } else {
                bad = true;
                return "redirect:/edit-operations/edit_profile";
            }
        }
        bad = false;
        return "redirect:/main/index";
    }

    @GetMapping(value = "/main/search")
    public String search(@RequestParam("name") String search,Model model){

        List<StudentDTO> list1 = studentServiceInter.find(search);
        List<TeacherDTO> list2 = teacherServiceInter.find(search);

        model.addAttribute("search1List",list1);
        model.addAttribute("search2List",list2);
        return "/main/search";
    }


    public String bytePassword(String pass) {
        String password = new BCryptPasswordEncoder().encode(pass);
        return password;
    }

}