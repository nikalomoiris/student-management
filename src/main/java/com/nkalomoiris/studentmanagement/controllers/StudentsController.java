package com.nkalomoiris.studentmanagement.controllers;

import com.nkalomoiris.studentmanagement.models.Student;
import com.nkalomoiris.studentmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    @Autowired
    StudentRepository studentRepository;

    // TODO use dto and dao
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{student_id}")
    public Student getById(@PathVariable Long student_id) {
        return studentRepository.getById(student_id);
    }

    // TODO use this method for update too
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @RequestMapping(value = "{student_id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long student_id) {
        studentRepository.deleteById(student_id);
    }
}
