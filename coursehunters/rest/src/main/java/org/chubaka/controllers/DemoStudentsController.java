package org.chubaka.controllers;

import org.chubaka.entity.Student;
import org.chubaka.service.IStudentService;
import org.chubaka.service.StudentErrorResponse;
import org.chubaka.service.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoStudentsController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("Maria", 22));
//        students.add(new Student("Kolya", 21));
        return studentService.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= studentService.getStudents().size() || studentId < 0) {
            throw new StudentNotFoundException("out of range " + studentId);
        }
        return studentService.getStudents().get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
