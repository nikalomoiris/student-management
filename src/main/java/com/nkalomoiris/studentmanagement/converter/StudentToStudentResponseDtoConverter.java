package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;
import com.nkalomoiris.studentmanagement.dto.student.StudentResponseDto;
import com.nkalomoiris.studentmanagement.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentResponseDtoConverter implements Converter<Student, StudentResponseDto> {

    Logger logger = LoggerFactory.getLogger(StudentToStudentResponseDtoConverter.class);

    @Override
    public StudentResponseDto convert(Student source) {

        logger.info("Converting Student to StudentResponseDto");
        logger.info(source.toString());

        var studentsGroupResponseDto = new StudentsGroupDto(source.getGroup().getId(), source.getGroup().getName());

        return new StudentResponseDto(source.getFirstName(), source.getLastName(), source.getEmail(),
                source.getId(), studentsGroupResponseDto, source.getStudentAge(), source.getStudentLevel(),
                source.getCreationDate());
    }
}
