package com.nkalomoiris.studentmanagement.services;

import com.nkalomoiris.studentmanagement.models.Student;
import com.nkalomoiris.studentmanagement.repositories.StudentRepository;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Scheduled(fixedRate = 60000)
    private void calculateStudentOldness() {
        logger.info("Checking students oldness");
        studentRepository.findAll().stream().forEach(student -> {
           if (differenceInMinutes(student.getStudent_creation_date()) > 60L) {
               logger.info(student.getStudent_first_name() + " " + student.getStudent_last_name()
                       + " is in the system for more than one minute");
           }
        });
    }

    private Long differenceInMinutes(Date date) {
        long diff = new Date().getTime() - date.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(diff);
    }
}
