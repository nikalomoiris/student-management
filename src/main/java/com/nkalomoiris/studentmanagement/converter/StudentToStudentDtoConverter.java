package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.student.StudentDto;
import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentDtoConverter implements Converter<Student, StudentDto> {

    @Override
    public StudentDto convert(Student source) {

        var Group = new Group(source.getGroup().getId(), source.getGroup().getName(),
                source.getGroup().getStudents()); // TODO replace Group with the dto when ready

        return new StudentDto(source.getFirstName(), source.getLastName(), source.getEmail(),
                source.getId(), Group, source.getStudentAge(), source.getStudentLevel(),
                source.getCreationDate());
    }
}
