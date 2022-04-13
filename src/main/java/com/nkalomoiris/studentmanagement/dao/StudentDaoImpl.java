package com.nkalomoiris.studentmanagement.dao;

import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
class StudentDaoImpl extends AbstractDaoImpl<Student, Long, StudentRepository> implements StudentDao {
    public StudentDaoImpl(StudentRepository jpaRepository) {
        super(jpaRepository);
    }
}
