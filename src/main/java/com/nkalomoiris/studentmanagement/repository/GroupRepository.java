package com.nkalomoiris.studentmanagement.repository;

import com.nkalomoiris.studentmanagement.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
