package com.cleevio.task.eshop.services.as;


import com.cleevio.task.eshop.common.dto.ImageDTO;
import com.cleevio.task.eshop.services.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// AS - Application Service
// One of the main differences is that it's not transactional, unlike services in "service facade"
// Should never be called directly in a controller
@Component
public class ImageAS {
    @Autowired
    private ImageDao imageDao;

    public ImageDTO getImageDTOById(Long imageId) {
        return imageDao.findImageById(imageId);
    }

    public Long getIdFromImageDTO(ImageDTO dto) {
        if (dto == null) {
            return null;
        }

        return dto.getId();
    }

}
