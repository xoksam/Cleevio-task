package com.cleevio.task.eshop.common.dto.exception;

import lombok.Data;

@Data
public class InvalidFieldDTO {
    private String field;
    private String message;
}
