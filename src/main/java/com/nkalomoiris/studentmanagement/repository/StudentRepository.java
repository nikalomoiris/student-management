package com.nkalomoiris.studentmanagement.repository;

import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends AbstractRepository<Student, Long>, JpaSpecificationExecutor<Student> {
}
