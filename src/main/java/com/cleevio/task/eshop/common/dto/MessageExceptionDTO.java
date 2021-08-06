package com.cleevio.task.eshop.common.dto;

import lombok.Data;

@Data
public class MessageExceptionDTO {
    private String message;
    private String httpStatus;
}
