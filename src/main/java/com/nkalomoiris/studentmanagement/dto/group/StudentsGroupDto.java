package com.nkalomoiris.studentmanagement.dto.group;

public class StudentsGroupDto extends AbstractGroupDto{

    private final Long id;

    public StudentsGroupDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
