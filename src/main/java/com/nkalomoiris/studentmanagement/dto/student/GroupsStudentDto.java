package com.nkalomoiris.studentmanagement.dto.student;

import java.time.LocalDateTime;

public class GroupsStudentDto extends AbstractStudentDto{

    private final Long id;

    private final Integer studentAge;

    public GroupsStudentDto(Long id, String firstName, String lastName, String email, Integer age, String level, LocalDateTime dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentAge = age;
        this.studentLevel = level;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public Integer getStudentAge() {
        return studentAge;
    }
}
