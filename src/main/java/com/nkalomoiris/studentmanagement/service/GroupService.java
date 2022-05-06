package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dto.group.AbstractCreateGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.AbstractGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.CreateGroupRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group getById(Long id);

    Group create(AbstractGroupDto abstractGroupDto);

    void deleteById(Long id);
}
