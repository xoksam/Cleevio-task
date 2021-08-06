package com.cleevio.task.eshop.common.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends MessageException {

    public EntityNotFoundException(Class<?> clazz, String fieldName, Object fieldValue) {
        super(HttpStatus.NOT_FOUND, "Entity " + clazz.getSimpleName() + " with " + fieldName + "='" + fieldValue + "' not found!");
    }
}
