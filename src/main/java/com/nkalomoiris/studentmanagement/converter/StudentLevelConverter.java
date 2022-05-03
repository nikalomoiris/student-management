package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.model.StudentLevel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StudentLevelConverter implements AttributeConverter<StudentLevel, String> {

    @Override
    public String convertToDatabaseColumn(StudentLevel category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public StudentLevel convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(StudentLevel.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
