package com.cleevio.task.eshop.model.image;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "IMAGE")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(generator = "hibernate_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Size(max = 128)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "DATA")
    private String data;

    @Size(max = 512)
    @Column(name = "DESCRIPTION")
    private String description;
}
