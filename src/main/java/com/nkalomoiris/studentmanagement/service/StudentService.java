package com.nkalomoiris.studentmanagement.service;


import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.dto.student.UpdateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface StudentService {

    List<Student> findAll(Specification<Student> studentSpecification);

    Student getById(Long id);

    Student create(CreateStudentRequestDto createStudentRequestDto);

    Student update(UpdateStudentRequestDto updateStudentRequestDto);

    void deleteById(Long id);
}
