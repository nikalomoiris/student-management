package com.nkalomoiris.studentmanagement.controller;

import com.nkalomoiris.studentmanagement.dto.StudentDto;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentRepository studentRepository;

    private final ConversionService conversionService;

    @Autowired
    public StudentsController(StudentRepository studentRepository, ConversionService conversionService) {
        this.studentRepository = studentRepository;
        this.conversionService = conversionService;
    }

    // TODO use dto and dao for requests and responds
    @GetMapping
    public List<StudentDto> getAll() {

        List<Student> students = studentRepository.findAll();

        List<StudentDto> results = new ArrayList<>(students.size());

        students.forEach(student -> results.add(convert(student)));

        return results;
    }

    @GetMapping
    @RequestMapping("{student_id}")
    public StudentDto getById(@PathVariable Long student_id) {
        return convert(studentRepository.getById(student_id));
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

    private StudentDto convert(Student student) {
        return conversionService
                .convert(student, StudentDto.class);
    }
}
