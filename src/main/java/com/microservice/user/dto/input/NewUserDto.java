package com.microservice.user.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewUserDto {

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("user:name")
    private String userName;

    private String password;

    private String email;

    private String phone;

}
