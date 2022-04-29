package com.nkalomoiris.studentmanagement.dto.group;

import com.nkalomoiris.studentmanagement.dto.student.GroupsStudentDto;

import java.util.List;

public class GroupResponseDto extends AbstractGroupDto{

    private final Long id;
    private final List<GroupsStudentDto> students;

    public GroupResponseDto(Long id, String name, List<GroupsStudentDto> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public List<GroupsStudentDto> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("GroupResponseDto{" +
                        "id=%s" +
                        ", \nname=%s" +
                        ", \nstudents=%s" +
                        "}",
                id, name, students
        );
    }
}
