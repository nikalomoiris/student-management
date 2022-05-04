package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dao.GroupDao;
import com.nkalomoiris.studentmanagement.dto.group.AbstractGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.CreateGroupRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public Group getById(Long id) {
        return groupDao.getById(id);
    }

    @Override
    public Group create(Group group) {
        return groupDao.save(group);
    }

    @Override
    public void deleteById(Long id) {
        groupDao.deleteById(id);
    }

    private <T extends AbstractGroupDto> Group copy(T source, Group group) {
        group.setName(source.getName());
        return group;
    }
}
