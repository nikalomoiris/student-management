package com.nkalomoiris.studentmanagement.specification;

import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification {
    public Specification<Student> getStudentQuery(StudentFilter studentFilter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (studentFilter != null && studentFilter.getFirstName() != null) {
                predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + studentFilter.getFirstName() + "%"));
            }

            if (studentFilter != null && studentFilter.getLastName() != null) {
                predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + studentFilter.getLastName() + "%"));
            }

            if (studentFilter != null && studentFilter.getSsn() != null) {
                predicates.add(criteriaBuilder.equal(root.get("ssn"), studentFilter.getSsn()));
            }

            if (studentFilter != null && studentFilter.getEmail() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), studentFilter.getEmail()));
            }

            if (studentFilter != null && studentFilter.getStudentAge() != null) {
                predicates.add(criteriaBuilder
                        .greaterThanOrEqualTo(root.get("studentAge"), studentFilter.getStudentAge()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
