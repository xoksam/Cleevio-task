package com.cleevio.task.eshop.common.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MessageExceptionDTO {
    private String message;
    private HttpStatus httpStatus;
}
