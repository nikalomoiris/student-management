package com.nkalomoiris.studentmanagement.dto.group;

import com.nkalomoiris.studentmanagement.dto.student.StudentDto;

import java.util.List;

public class GroupDto extends AbstractGroupDto{

    private final Long id;

    public GroupDto(Long id, String name, List<StudentDto> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("StudentDto{" +
                        "id=%s" +
                        ", name=%s" +
                        ", students=%s" +
                        "}",
                id, name, students
        );
    }
}
