package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.group.GroupDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StudentToStudentDtoConverter implements Converter<Student, StudentDto> {

    // TODO Ask Michali why the commented part below breaks the code
//    private final ConversionService conversionService;
//
//    public StudentToStudentDtoConverter(ConversionService conversionService) {
//        this.conversionService = conversionService;
//    }

    @Override
    public StudentDto convert(Student source) {

        var Group = new Group(source.getGroup().getId(), source.getGroup().getName(),
                source.getGroup().getStudents());

        return new StudentDto(source.getFirstName(), source.getLastName(), source.getEmail(),
                source.getId(), new GroupDto(1L, "Dummy", new ArrayList<>())/*conversionService.convert(Group, GroupDto.class)*/, source.getStudentAge(), source.getStudentLevel(),
                source.getCreationDate());
    }
}
