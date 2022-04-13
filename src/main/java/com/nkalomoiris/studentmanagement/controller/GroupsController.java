package com.nkalomoiris.studentmanagement.controller;

import com.nkalomoiris.studentmanagement.dto.group.GroupDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import com.nkalomoiris.studentmanagement.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {

    private final GroupRepository groupRepository;

    private final ConversionService conversionService;

    @Autowired
    public GroupsController(GroupRepository groupRepository, ConversionService conversionService) {
        this.groupRepository = groupRepository;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<GroupDto> getAll() {

        List<Group> groups = groupRepository.findAll();

        List<GroupDto> results = new ArrayList<>(groups.size());

        groups.forEach(group -> results.add(convert(group)));

        return results;
    }

    @GetMapping
    @RequestMapping("{group_id}")
    public GroupDto getById(@PathVariable Long group_id) {
        return convert(groupRepository.getById(group_id));
    }

    @PostMapping
    public GroupDto create(@RequestBody Group group) {
        return convert(groupRepository.save(group));
    }

    @GetMapping
    @RequestMapping("/student-list/{group_id}")
    public List<Student> studentList(@PathVariable Long group_id) {
        return groupRepository.getById(group_id).getStudents();
    }

    @RequestMapping(value = "{group_id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long group_id) {
        groupRepository.deleteById(group_id);
    }

    private GroupDto convert(Group group) {
        return conversionService
                .convert(group, GroupDto.class);
    }

}