package com.nkalomoiris.studentmanagement.controller;

import com.nkalomoiris.studentmanagement.dao.GroupDao;
import com.nkalomoiris.studentmanagement.dto.group.GroupDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {

    private final GroupDao groupDao;

    private final ConversionService conversionService;

    @Autowired
    public GroupsController(GroupRepository groupRepository, GroupDao groupDao, ConversionService conversionService) {
        this.groupDao = groupDao;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<GroupDto> getAll() {

        List<Group> groups = groupDao.findAll();

        List<GroupDto> results = new ArrayList<>(groups.size());

        groups.forEach(group -> results.add(convert(group)));

        return results;
    }

    @GetMapping
    @RequestMapping("{group_id}")
    public GroupDto getById(@PathVariable Long group_id) {
        return convert(groupDao.getById(group_id));
    }

    @PostMapping
    public GroupDto create(@RequestBody Group group) {
        return convert(groupDao.save(group));
    }

    @RequestMapping(value = "{group_id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long group_id) {
        groupDao.deleteById(group_id);
    }

    private GroupDto convert(Group group) {
        return conversionService
                .convert(group, GroupDto.class);
    }

}
