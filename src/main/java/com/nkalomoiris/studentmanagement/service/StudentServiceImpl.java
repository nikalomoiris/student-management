package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dao.StudentDao;
import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.dto.student.*;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.model.StudentLevel;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    private final ConversionService conversionService;

    public StudentServiceImpl(StudentDao studentDao, ConversionService conversionService) {
        this.studentDao = studentDao;
        this.conversionService = conversionService;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    @Transactional
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Override
    @Transactional
    public Student create(CreateStudentRequestDto createStudentRequestDto) {
        Student newStudent = new Student();
        return studentDao.save(copy(createStudentRequestDto, newStudent));
    }

    @Override
    @Transactional
    public Student update(UpdateStudentRequestDto updateStudentRequestDto) {
        var student = studentDao.getById(updateStudentRequestDto.getId());
        return studentDao.save(copy(updateStudentRequestDto, student));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    private <T extends AbstractCreateStudentDto> Student copy(T source, Student student) {
        student.setFirstName(source.getFirstName());
        student.setLastName(source.getLastName());
        student.setEmail(source.getEmail());
        student.setStudentAge(source.getStudentAge());
        student.setStudentLevel(StudentLevel.valueOf(source.getStudentLevel()));
        StudentsGroupDto studentsGroupDto = source.getGroup();
        student.setGroup(new Group(studentsGroupDto.getId()));
        student.setSsn(source.getSsn());
        return student;
    }

}
