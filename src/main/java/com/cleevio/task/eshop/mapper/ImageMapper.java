package com.cleevio.task.eshop.mapper;

import com.cleevio.task.eshop.common.dto.ImageDTO;
import com.cleevio.task.eshop.model.image.Image;
import sk.annotation.library.jam.annotations.*;

// https://github.com/AnnotationSro/java-annotation-mapper
@EnableSpring
@Mapper
public abstract class ImageMapper {
    @MapperConfig(fieldIgnore = @FieldIgnore("id"))
    public abstract ImageDTO mapImageToDto(Image image);

    public abstract Image mapImageDtoToEntity(ImageDTO dto);
}
