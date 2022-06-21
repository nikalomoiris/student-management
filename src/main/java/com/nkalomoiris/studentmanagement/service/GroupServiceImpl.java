package com.nkalomoiris.studentmanagement.service;

import com.nkalomoiris.studentmanagement.dto.group.AbstractGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.UpdateGroupRequestDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public Group getById(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    @Transactional
    public Group create(AbstractGroupDto abstractGroupDto) {
        Group newGroup = new Group();
        return groupRepository.save(copy(abstractGroupDto, newGroup));
    }

    @Override
    @Transactional
    public Group update(UpdateGroupRequestDto updateGroupRequestDto) {
        var group = groupRepository.getById(updateGroupRequestDto.getId());
        return groupRepository.save(copy(updateGroupRequestDto, group));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }

    private <T extends AbstractGroupDto> Group copy(T source, Group group) {
        group.setName(source.getName());
        return group;
    }
}
