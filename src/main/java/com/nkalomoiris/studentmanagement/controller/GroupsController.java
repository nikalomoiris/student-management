package com.nkalomoiris.studentmanagement.controller;

import com.nkalomoiris.studentmanagement.dto.group.AbstractCreateGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.AbstractGroupDto;
import com.nkalomoiris.studentmanagement.dto.group.CreateGroupRequestDto;
import com.nkalomoiris.studentmanagement.dto.group.GroupResponseDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {

    Logger logger = LoggerFactory.getLogger(GroupsController.class);

    private final GroupService groupService;

    private final ConversionService conversionService;

    @Autowired
    public GroupsController(GroupService groupService, ConversionService conversionService) {
        this.groupService = groupService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<GroupResponseDto> getAll() {

        List<Group> groups = groupService.findAll();

        List<GroupResponseDto> results = new ArrayList<>(groups.size());

        groups.forEach(group -> results.add(convert(group)));

        return results;
    }

    @GetMapping
    @RequestMapping("{group_id}")
    public GroupResponseDto getById(@PathVariable Long group_id) {
        return convert(groupService.getById(group_id));
    }

    @PostMapping
    public GroupResponseDto create(@RequestBody CreateGroupRequestDto createGroupRequestDto) {
        return convert(groupService.create(createGroupRequestDto));
    }

    @RequestMapping(value = "{group_id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long group_id) {
        groupService.deleteById(group_id);
    }

    private GroupResponseDto convert(Group group) {
        return conversionService
                .convert(group, GroupResponseDto.class);
    }

}
