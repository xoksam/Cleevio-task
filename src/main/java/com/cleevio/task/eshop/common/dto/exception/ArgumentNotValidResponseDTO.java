package com.cleevio.task.eshop.common.dto.exception;

import lombok.Data;

import java.util.List;

@Data
public class ArgumentNotValidResponseDTO {
    private List<InvalidFieldDTO> invalidFields;
}
