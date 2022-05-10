package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.model.StudentLevel;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentResponseDto extends AbstractStudentDto implements Serializable {

    private final Long id;

    private final StudentsGroupDto group;

    private final Integer studentAge;

    public StudentResponseDto(String firstName, String lastName, String email, Long id, StudentsGroupDto group,
                              Integer studentAge, StudentLevel studentLevel, LocalDateTime dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.group = group;
        this.studentAge = studentAge;
        this.studentLevel = studentLevel.toString();
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public StudentsGroupDto getGroup() {
        return group;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    @Override
    public String toString() {
        return "StudentResponseDto{" +
                "id=" + id +
                ", group=" + group +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentAge=" + studentAge +
                ", studentLevel='" + studentLevel + '\'' +
                ", dob=" + dob +
                '}';
    }
}
