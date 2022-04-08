package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.model.Group;

public abstract class AbstractStudentDto {

    protected String firstName;

    protected String lastName;

    protected String email;

    protected Integer studentAge;

    protected Integer studentLevel;

    protected Group group; // TODO replace Group with the dto when ready

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(Integer studentLevel) {
        this.studentLevel = studentLevel;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
