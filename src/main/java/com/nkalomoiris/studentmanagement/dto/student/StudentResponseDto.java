package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.model.StudentLevel;

import java.io.Serializable;

public class StudentResponseDto extends AbstractStudentDto implements Serializable {

    private final Long id;

    private final StudentsGroupDto group;

    public StudentResponseDto(String firstName, String lastName, String email, Long id, StudentsGroupDto group,
                              Integer studentAge, StudentLevel studentLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.group = group;
        this.studentAge = studentAge;
        this.studentLevel = studentLevel.toString();
    }

    public Long getId() {
        return id;
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
                        ", studentAge=%s" +
                        ", studentLevel=%s" +
                        ", group=%s" +
                        "}",
                id, firstName, lastName, email, studentAge, studentLevel, group
        );
    }
}
