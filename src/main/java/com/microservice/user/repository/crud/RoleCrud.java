package com.microservice.user.repository.crud;

import com.microservice.user.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleCrud extends JpaRepository<RoleEntity, Integer> {



}
