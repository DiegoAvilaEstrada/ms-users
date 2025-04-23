package com.microservice.user.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseHttpDto {

    private Integer codeHttp;

    private String messsage;

    private Object data;

    public ResponseHttpDto(Integer codeHttp, String messsage) {
        this.codeHttp = codeHttp;
        this.messsage = messsage;
    }

    public ResponseHttpDto(Integer codeHttp, String messsage,Object data) {
        this.codeHttp = codeHttp;
        this.messsage = messsage;
        this.data=data;
    }

}
