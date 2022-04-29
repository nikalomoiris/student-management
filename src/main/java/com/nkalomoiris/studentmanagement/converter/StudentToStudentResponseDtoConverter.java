package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentResponseDto;
import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentResponseDtoConverter implements Converter<Student, StudentResponseDto> {

    @Override
    public StudentResponseDto convert(Student source) {

        var studentsGroupResponseDto = new StudentsGroupDto(source.getGroup().getId(), source.getGroup().getName());

        return new StudentResponseDto(source.getFirstName(), source.getLastName(), source.getEmail(),
                source.getId(), studentsGroupResponseDto, source.getStudentAge(), source.getStudentLevel(),
                source.getCreationDate());
    }
}
