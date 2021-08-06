package com.cleevio.task.eshop.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO split into 2, because image can be a huge string
// Also, we don't always need the image
@EqualsAndHashCode(callSuper = true)
@Data
public class WatchDetailDTO extends WatchDTO {
    private ImageDTO image;
}
