package com.ibm.sri.tech.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    SESSION_NOT_FOUND(HttpStatus.NOT_FOUND.toString(), "ERR_001","Session not found","The User Session may expired","");

    private final String httpCode;
    private final String code;
    private final String title;
    private final String message;
    private final String detail;

}
