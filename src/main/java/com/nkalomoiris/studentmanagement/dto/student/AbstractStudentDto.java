package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;

public abstract class AbstractStudentDto {

    protected String firstName;

    protected String lastName;

    protected String email;

    protected StudentsGroupDto group;

    protected Integer studentAge;

    protected String studentLevel;

    protected String ssn;

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

    public StudentsGroupDto getGroup() {
        return group;
    }

    public void setGroup(StudentsGroupDto group) {
        this.group = group;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

}
