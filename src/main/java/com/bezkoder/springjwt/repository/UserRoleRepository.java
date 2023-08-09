package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.entity.UserRoleEntity;
import com.bezkoder.springjwt.entity.UserRoleIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, UserRoleIds> {

}
