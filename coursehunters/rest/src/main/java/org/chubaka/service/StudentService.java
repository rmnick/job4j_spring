package org.chubaka.service;

import org.chubaka.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService implements IStudentService {
    @Override
    public List<Student> getStudents() {
        List<Student> result = new ArrayList<>();
        result.add(new Student("Maria", 22));
        result.add(new Student("Kolya", 21));
        return result;
    }
}
