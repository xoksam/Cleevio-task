package com.cleevio.task.eshop.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ImageDTO {
    private Long id;

    @Size(max = 128)
    private String name;

    @NotNull
    private String data;

    @Size(max = 512)
    private String description;
}
