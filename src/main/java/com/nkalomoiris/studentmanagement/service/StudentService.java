package com.nkalomoiris.studentmanagement.service;


import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.dto.student.UpdateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student getById(Long id);

    Student create(CreateStudentRequestDto createStudentRequestDto);

    Student update(UpdateStudentRequestDto updateStudentRequestDto);

    void deleteById(Long id);
}
