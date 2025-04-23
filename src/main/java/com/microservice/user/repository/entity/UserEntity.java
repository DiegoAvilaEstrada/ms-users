package com.microservice.user.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Boolean approved;

    @Column(name = "role_id")
    @ManyToOne
    private RoleEntity role;

    @Column(name = "ts_insert")
    private Date tsInsert;

}
