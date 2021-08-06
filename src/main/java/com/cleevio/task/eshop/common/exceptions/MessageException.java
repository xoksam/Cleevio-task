package com.cleevio.task.eshop.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class MessageException extends RuntimeException {

    @Getter
    protected HttpStatus httpStatus = null;
    public MessageException(String message) {
        super(message);
    }

    public MessageException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
