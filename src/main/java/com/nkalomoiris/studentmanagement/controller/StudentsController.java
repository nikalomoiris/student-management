package com.nkalomoiris.studentmanagement.controller;

import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentResponseDto;
import com.nkalomoiris.studentmanagement.dto.student.UpdateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    Logger logger = LoggerFactory.getLogger(StudentsController.class);

    private final StudentService studentService;

    private final ConversionService conversionService;

    @Autowired
    public StudentsController(StudentService studentService, ConversionService conversionService) {
        this.studentService = studentService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {

        List<Student> students = studentService.findAll();

        for (Student s :
            students) {
            logger.info(s.toString());
        }

        List<StudentResponseDto> results = new ArrayList<>(students.size());

        students.forEach(student -> results.add(convert(student)));

        return results;
    }

    @GetMapping
    @RequestMapping("{student_id}")
    public StudentResponseDto getById(@PathVariable Long student_id) {
        return convert(studentService.getById(student_id));
    }

    @PostMapping
    public StudentResponseDto create(@RequestBody CreateStudentRequestDto createStudentRequestDto) {
        return convert(studentService.create(createStudentRequestDto));
    }

    @PutMapping
    public StudentResponseDto update(@RequestBody UpdateStudentRequestDto updateStudentRequestDto) {
        return convert(studentService.update(updateStudentRequestDto));
    }

    @RequestMapping(value = "{student_id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long student_id) {
        studentService.deleteById(student_id);
    }

    private StudentResponseDto convert(Student student) {
        return conversionService
                .convert(student, StudentResponseDto.class);
    }
}
