package com.cleevio.task.eshop.services.dao;

import com.cleevio.task.eshop.common.dto.ImageDTO;
import com.cleevio.task.eshop.common.exceptions.EntityNotFoundException;
import com.cleevio.task.eshop.mapper.ImageMapper;
import com.cleevio.task.eshop.model.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao extends AbstractCommonDao {

    @Autowired
    private ImageMapper imageMapper;

    public ImageDTO findImageById(Long imageId) {
        if (imageId == null) {
            return null;
        }
        var image = find(Image.class, imageId);

        if (image == null) {
            throw new EntityNotFoundException(Image.class, "id", imageId);
        }

        return imageMapper.mapImageToDto(image);
    }

}
