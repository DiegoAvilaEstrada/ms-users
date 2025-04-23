package com.microservice.user.repository.crud;

import com.microservice.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCrud extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select * from user where username = ? ;", nativeQuery = true)
    Optional<UserEntity> getByUsername(String username);


}
