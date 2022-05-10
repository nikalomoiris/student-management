package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dao.GroupDao;
import com.nkalomoiris.studentmanagement.dao.StudentDao;
import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.dto.student.AbstractCreateStudentDto;
import com.nkalomoiris.studentmanagement.dto.student.CreateStudentRequestDto;
import com.nkalomoiris.studentmanagement.dto.student.UpdateStudentRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.model.StudentLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Value("${application.global-constants.group-max-size:5}")
    private Integer GROUP_MAX_SIZE;

    private final StudentDao studentDao;

    private final GroupDao groupDao;

    private final ConversionService conversionService;

    public StudentServiceImpl(StudentDao studentDao, GroupDao groupDao, ConversionService conversionService) {
        this.studentDao = studentDao;
        this.groupDao = groupDao;
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
        if(groupIsFull(createStudentRequestDto.getGroup().getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Specified group is full"
            );
        }
        Student newStudent = new Student();
        return studentDao.save(copy(createStudentRequestDto, newStudent));
    }

    @Override
    @Transactional
    public Student update(UpdateStudentRequestDto updateStudentRequestDto) {
        var student = studentDao.getById(updateStudentRequestDto.getId());
        if(student.getGroup().getId() != updateStudentRequestDto.getGroup().getId()) {
            if (groupIsFull(updateStudentRequestDto.getGroup().getId())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Specified group is full"
                );
            }
        }
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
        student.setStudentAge(calculateAgeInYears(source.getDob()));
        student.setStudentLevel(StudentLevel.valueOf(source.getStudentLevel()));
        StudentsGroupDto studentsGroupDto = source.getGroup();
        student.setGroup(new Group(studentsGroupDto.getId()));
        student.setSsn(source.getSsn());
        student.setDob(source.getDob());
        return student;
    }

    private int calculateAgeInYears(LocalDateTime dob) {
        return (int) ChronoUnit.YEARS.between(dob, LocalDateTime.now());
    }

    private boolean groupIsFull(Long groupId) {
        return groupDao.getById(groupId).getStudents().size() >= GROUP_MAX_SIZE;
    }

}
