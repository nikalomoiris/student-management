package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.group.GroupResponseDto;
import com.nkalomoiris.studentmanagement.dto.student.GroupsStudentDto;
import com.nkalomoiris.studentmanagement.model.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Component
public class GroupToGroupResponseDtoConverter implements Converter<Group, GroupResponseDto> {

    Logger logger = LoggerFactory.getLogger(GroupToGroupResponseDtoConverter.class);

    @Override
    public GroupResponseDto convert(Group source) {

        logger.info("Converting Group to GroupResponseDto");

        var convertedStudents = new ArrayList<GroupsStudentDto>();

        if (!CollectionUtils.isEmpty(source.getStudents())) {
            source.getStudents().forEach(student ->
                    convertedStudents.add(new GroupsStudentDto(student.getId(), student.getFirstName(),
                        student.getLastName(), student.getEmail(), student.getStudentAge(),
                        student.getStudentLevel().name())));
        }

        return new GroupResponseDto(source.getId(), source.getName(), convertedStudents);
    }
}
