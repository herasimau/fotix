package com.fotix.api.repository;

import com.fotix.api.entities.group.Group;
import com.fotix.api.entities.group.GroupName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by herasimau on 02/10/16.
 */
public interface GroupsRepository extends JpaRepository<Group,Long> {
    Group getByName(GroupName name);
}
