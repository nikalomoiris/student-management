package com.nkalomoiris.studentmanagement.repository;

import com.nkalomoiris.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
