package com.enigmacamp.learnspringbootjparel.model.response;

import lombok.Data;

@Data
public abstract class CommonResponse {
    private String code;
    private String status;
    private String message;
}
