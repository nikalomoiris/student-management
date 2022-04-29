package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;

import java.io.Serializable;
import java.util.Date;

public class StudentResponseDto extends AbstractStudentDto implements Serializable {

    private final Long id;

    protected StudentsGroupDto group;

    protected Integer studentAge;

    protected Integer studentLevel;

    private final Date creationDate;

    public StudentResponseDto(String firstName, String lastName, String email, Long id, StudentsGroupDto group, Integer studentAge, Integer studentLevel,
                              Date creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.group = group;
        this.studentAge = studentAge;
        this.studentLevel = studentLevel;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public Integer getStudentLevel() {
        return studentLevel;
    }

    public StudentsGroupDto getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("StudentDto{" +
                        "id=%s" +
                        ", firstName=%s" +
                        ", lastName=%s" +
                        ", email=%s" +
                        ", creationDate=%s" +
                        ", studentAge=%s" +
                        ", studentLevel=%s" +
                        ", group=%s" +
                        "}",
                id, firstName, lastName, email,
                creationDate, studentAge, studentLevel, group
        );
    }
}
