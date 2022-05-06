package com.nkalomoiris.studentmanagement.dto.student;

public class GroupsStudentDto extends AbstractStudentDto{

    private final Long id;

    public GroupsStudentDto(Long id, String firstName, String lastName, String email, Integer age, String level) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentAge = age;
        this.studentLevel = level;
    }

    public Long getId() {
        return id;
    }
}
