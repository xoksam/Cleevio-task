package com.cleevio.task.eshop.mapper;

import com.cleevio.task.eshop.common.dto.WatchDTO;
import com.cleevio.task.eshop.common.dto.WatchDetailDTO;
import com.cleevio.task.eshop.model.watch.Watch;
import com.cleevio.task.eshop.services.as.ImageAS;
import sk.annotation.library.jam.annotations.*;

@EnableSpring
@Mapper
@MapperConfig(
        withCustom = ImageAS.class,
        fieldMapping = @FieldMapping(
                sTypes = Watch.class, dTypes = WatchDetailDTO.class,
                s = "imageId",
                d = "image"
        )
)
// https://github.com/AnnotationSro/java-annotation-mapper
public abstract class WatchMapper {
    public abstract WatchDTO mapWatchToDto(Watch watch);

    public abstract WatchDetailDTO mapWatchToDetailDto(Watch watch);

    @MapperConfig(fieldIgnore = @FieldIgnore("id"))
    public abstract Watch mapWatchDtoToEntity(WatchDTO dto, @Return Watch watch);

    @MapperConfig(fieldIgnore = @FieldIgnore("id"))
    public abstract Watch mapWatchDetailDtoToEntity(WatchDetailDTO dto, @Return Watch watch);
}
