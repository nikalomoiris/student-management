package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.group.GroupResponseDto;
import com.nkalomoiris.studentmanagement.dto.student.GroupsStudentDto;
import com.nkalomoiris.studentmanagement.model.Group;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Component
public class GroupToGroupResponseDtoConverter implements Converter<Group, GroupResponseDto> {

    @Override
    public GroupResponseDto convert(Group source) {

        var convertedStudents = new ArrayList<GroupsStudentDto>();

        if (!CollectionUtils.isEmpty(source.getStudents())) {
            source.getStudents().forEach(student ->
                    convertedStudents.add(new GroupsStudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail())));
        }

        return new GroupResponseDto(source.getId(), source.getName(), convertedStudents);
    }
}
