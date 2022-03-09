package com.nkalomoiris.studentmanagement.controllers;

import com.nkalomoiris.studentmanagement.models.Group;
import com.nkalomoiris.studentmanagement.models.Student;
import com.nkalomoiris.studentmanagement.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{group_id}")
    public Group getById(@PathVariable Long group_id) {
        return groupRepository.getById(group_id);
    }

    @PostMapping
    public Group create(@RequestBody Group group) {
        return groupRepository.save(group);
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
}
