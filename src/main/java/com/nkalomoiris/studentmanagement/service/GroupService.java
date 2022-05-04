package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dto.group.CreateGroupRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group getById(Long id);

    Group create(Group group);

    void deleteById(Long id);
}
