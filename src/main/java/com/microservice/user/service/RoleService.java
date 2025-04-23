package com.microservice.user.service;

import com.microservice.user.exception.UserException;
import com.microservice.user.repository.crud.RoleCrud;
import com.microservice.user.repository.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleCrud roleCrud;

    public RoleEntity getRoleById(Integer id){
        Optional<RoleEntity> roleEntity = roleCrud.findById(id);

        if(!roleEntity.isEmpty()){
            return roleEntity.get();
        }

        throw new UserException("role not found, ROLE NOT FOUND: ", id);

    }

}
