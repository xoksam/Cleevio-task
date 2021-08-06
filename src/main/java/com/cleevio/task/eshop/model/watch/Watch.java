package com.cleevio.task.eshop.model.watch;

import com.cleevio.task.eshop.common.enums.WatchType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "WATCH")
@Getter
@Setter
public class Watch {
    @Id
    @GeneratedValue(generator = "watch_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "watch_sequence", sequenceName = "watch_sequence", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Size(max = 128)
    @Column(name = "NAME")
    private String name;

    @Size(max = 512)
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "WATCH_TYPE")
    private WatchType watchType;

    @Column(name = "IMAGE_ID")
    private Long imageId;

    @Column(name = "CREATED")
    private LocalDateTime created;

}
