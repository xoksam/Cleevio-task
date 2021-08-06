package com.cleevio.task.eshop.common.dto;

import com.cleevio.task.eshop.common.enums.WatchType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class WatchDTO {
    private Long id;

    @Size(max = 128)
    private String name;

    @Size(max = 512)
    private String description;

    @NotNull
    private WatchType watchType;

    private LocalDateTime created;
}
