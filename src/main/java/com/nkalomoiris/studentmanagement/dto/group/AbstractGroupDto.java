package com.nkalomoiris.studentmanagement.dto.group;

import com.nkalomoiris.studentmanagement.dto.student.StudentDto;

import java.util.List;

public abstract class AbstractGroupDto {

    protected String name;

    protected List<StudentDto> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
