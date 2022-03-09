package com.nkalomoiris.studentmanagement.repositories;

import com.nkalomoiris.studentmanagement.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
