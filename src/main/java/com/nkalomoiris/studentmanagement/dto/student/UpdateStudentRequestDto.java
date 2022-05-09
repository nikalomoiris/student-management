package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.model.StudentLevel;

public class UpdateStudentRequestDto extends AbstractCreateStudentDto{

    private Long id;

    public UpdateStudentRequestDto(Long id, String firstName, String lastName, String email, StudentsGroupDto group,
                                   Integer studentAge, StudentLevel studentLevel, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.group = group;
        this.studentAge = studentAge;
        this.studentLevel = studentLevel.toString();
        this.ssn = ssn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
