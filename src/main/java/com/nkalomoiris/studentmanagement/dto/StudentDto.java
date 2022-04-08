package com.nkalomoiris.studentmanagement.dto;

import com.nkalomoiris.studentmanagement.model.Group;

import java.io.Serializable;
import java.util.Date;

public class StudentDto extends AbstractStudentDto implements Serializable {

    private final Long id;

    private final Group group; // TODO replace Group with the dto when ready

    private final Integer studentAge;

    private final Integer studentLevel;

    private final Date creationDate;

    public StudentDto(String firstName, String lastName, String email, Long id, Group group, Integer studentAge, Integer studentLevel,
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

    public Group getGroup() {
        return group;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public Integer getStudentLevel() {
        return studentLevel;
    }

    public Date getCreationDate() {
        return creationDate;
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
