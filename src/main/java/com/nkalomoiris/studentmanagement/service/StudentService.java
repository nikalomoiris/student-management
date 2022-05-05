package com.nkalomoiris.studentmanagement.service;


import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student getById(Long id);

    Student create(CreateStudentRequestDto createStudentRequestDto);

    void deleteById(Long id);
}
