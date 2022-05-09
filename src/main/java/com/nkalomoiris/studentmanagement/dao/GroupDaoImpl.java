package com.nkalomoiris.studentmanagement.dao;

import com.nkalomoiris.studentmanagement.model.Group;
import com.nkalomoiris.studentmanagement.repository.GroupRepository;
import org.springframework.stereotype.Component;

@Component
class GroupDaoImpl extends AbstractDaoImpl<Group, Long, GroupRepository> implements GroupDao {
    public GroupDaoImpl(GroupRepository jpaRepository) {
        super(jpaRepository);
    }
}
