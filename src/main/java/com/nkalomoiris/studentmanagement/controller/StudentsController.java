package com.nkalomoiris.studentmanagement.controller;

import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentResponseDto;
import com.nkalomoiris.studentmanagement.dto.student.UpdateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.service.StudentService;
import com.nkalomoiris.studentmanagement.specification.StudentFilter;
import com.nkalomoiris.studentmanagement.specification.StudentSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.domain.Specification;
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
    public List<StudentResponseDto> getAll(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName,
                                           @RequestParam(required = false) String ssn,
                                           @RequestParam(required = false) Integer studentAge,
                                           @RequestParam(required = false) String email) {

        StudentFilter studentFilter = new StudentFilter();
        studentFilter.setFirstName(firstName);
        studentFilter.setLastName(lastName);
        studentFilter.setSsn(ssn);
        studentFilter.setStudentAge(studentAge);
        studentFilter.setEmail(email);

        Specification<Student> studentSpecification = new StudentSpecification().getStudentQuery(studentFilter);

        List<Student> students = studentService.findAll(studentSpecification);

        List<StudentResponseDto> results = new ArrayList<>(students.size());

        students.forEach(student -> results.add(convert(student)));

        return results;
    }

    @GetMapping("{student_id}")
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

    @DeleteMapping(value = "{student_id}")
    public void deleteById(@PathVariable Long student_id) {
        studentService.deleteById(student_id);
    }

    private StudentResponseDto convert(Student student) {
        return conversionService
                .convert(student, StudentResponseDto.class);
    }
}
