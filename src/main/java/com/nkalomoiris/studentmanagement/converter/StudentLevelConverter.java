package com.nkalomoiris.studentmanagement.converter;

import com.nkalomoiris.studentmanagement.model.StudentLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StudentLevelConverter implements AttributeConverter<StudentLevel, String> {

    Logger logger = LoggerFactory.getLogger(StudentLevelConverter.class);

    @Override
    public String convertToDatabaseColumn(StudentLevel category) {
        if (category == null) {
            logger.warn("Category could not be converted to database column because it is null");
            return null;
        }
        logger.info("Category converted to database column: " + category.toString() + " -> " + category.getCode());
        return category.getCode();
    }

    @Override
    public StudentLevel convertToEntityAttribute(String code) {
        if (code == null) {
            logger.warn("Category could not be converted to entity attribute because it is null");
            return null;
        }

        logger.info("Category converted to entity attribute");
        return Stream.of(StudentLevel.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
