package org.chubaka.controllers;

import org.chubaka.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processing-text-form")
    public String doProcessForm(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "hello-student";
    }
}
