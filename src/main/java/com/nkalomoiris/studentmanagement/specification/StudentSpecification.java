package com.nkalomoiris.studentmanagement.specification;

import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentSpecification {
    public Specification<Student> getStudentQuery(Integer domainId, Calendar startDate, Calendar endDate, Integer gameId, Integer drawId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("domainId"), domainId));
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), startDate));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), endDate));

            if (gameId != null) {
                predicates.add(criteriaBuilder.equal(root.get("gameId"), gameId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
