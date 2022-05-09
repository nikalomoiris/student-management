package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dao.GroupDao;
import com.nkalomoiris.studentmanagement.dto.group.AbstractGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.UpdateGroupRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public Group getById(Long id) {
        return groupDao.getById(id);
    }

    @Override
    @Transactional
    public Group create(AbstractGroupDto abstractGroupDto) {
        Group newGroup = new Group();
        return groupDao.save(copy(abstractGroupDto, newGroup));
    }

    @Override
    @Transactional
    public Group update(UpdateGroupRequestDto updateGroupRequestDto) {
        var group = groupDao.getById(updateGroupRequestDto.getId());
        return groupDao.save(copy(updateGroupRequestDto, group));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        groupDao.deleteById(id);
    }

    private <T extends AbstractGroupDto> Group copy(T source, Group group) {
        group.setName(source.getName());
        return group;
    }
}
