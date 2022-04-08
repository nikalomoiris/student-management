package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.group.GroupDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentDto;
import com.nkalomoiris.studentmanagement.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Component
public class GroupToGroupDtoConverter implements Converter<Group, GroupDto> {

//    private final ConversionService conversionService;
//
//    @Autowired
//    public GroupToGroupDtoConverter(ConversionService conversionService) {
//        this.conversionService = conversionService;
//    }

    @Override
    public GroupDto convert(Group source) {

        var convertedStudents = new ArrayList<StudentDto>();

//        if (!CollectionUtils.isEmpty(source.getStudents())) {
//            source.getStudents().forEach(student ->
//                    convertedStudents.add(conversionService
//                            .convert(student, StudentDto.class)));
//        }

        return new GroupDto(source.getId(), source.getName(), convertedStudents);
    }
}
