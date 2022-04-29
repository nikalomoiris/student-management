package com.nkalomoiris.studentmanagement.dto.student;

public class GroupsStudentDto extends AbstractStudentDto{

    private final Long id;

    public GroupsStudentDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}
