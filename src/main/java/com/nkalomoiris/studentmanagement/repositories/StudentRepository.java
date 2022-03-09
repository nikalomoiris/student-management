package com.nkalomoiris.studentmanagement.repositories;

import com.nkalomoiris.studentmanagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
