package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dao.StudentDao;
import com.nkalomoiris.studentmanagement.dto.group.AbstractGroupDto;
import com.nkalomoiris.studentmanagement.dto.student.AbstractStudentDto;
import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Override
    public Student create(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    private <T extends AbstractStudentDto> Student copy(T source, Student student) {
        student.setFirstName(source.getFirstName());
        student.setLastName(source.getLastName());
        student.setEmail(source.getEmail());
        return student;
    }
}
