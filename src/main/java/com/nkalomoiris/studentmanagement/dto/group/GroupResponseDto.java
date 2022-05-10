package com.nkalomoiris.studentmanagement.dto.group;

import com.nkalomoiris.studentmanagement.dto.student.GroupsStudentDto;

import java.util.List;

public class GroupResponseDto extends AbstractGroupDto{

    private final Long id;
    private final List<GroupsStudentDto> students;

    private final Integer size;

    public GroupResponseDto(Long id, String name, List<GroupsStudentDto> students, Integer size) {
        this.id = id;
        this.size = size;
        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public List<GroupsStudentDto> getStudents() {
        return students;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "GroupResponseDto{" +
                "id=" + id +
                ", students=" + students +
                ", size=" + size +
                '}';
    }
}
