package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.model.StudentLevel;

import java.time.LocalDateTime;

public class UpdateStudentRequestDto extends AbstractCreateStudentDto{

    private Long id;

    public UpdateStudentRequestDto(Long id, String firstName, String lastName, String email, StudentsGroupDto group,
                                   StudentLevel studentLevel, String ssn, LocalDateTime dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.group = group;
        this.studentLevel = studentLevel.toString();
        this.ssn = ssn;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
