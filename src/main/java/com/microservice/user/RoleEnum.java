package com.microservice.user;

import lombok.Getter;

@Getter
public enum RoleEnum {

    ADMIN(1),
    USER(2);

    private Integer roleCode;

    RoleEnum(Integer roleCode) {
        this.roleCode = roleCode;
    }
}
