package com.ibm.sri.tech.exception;

import lombok.Getter;

@Getter
public class SessionException extends RuntimeException {

    private final String message;
    private final String code;
    private final String httpCode;
    private final String title;
    private final String details;

    public SessionException(ErrorEnum errorEnum, String details) {
        super(errorEnum.getMessage());
        this.httpCode = errorEnum.getHttpCode();
        this.code = errorEnum.getCode();
        this.message = errorEnum.getMessage();
        this.title = errorEnum.getTitle();
        this.details = details;
    }


}
