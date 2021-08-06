package com.cleevio.task.eshop.services.as;


import com.cleevio.task.eshop.common.dto.ImageDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

// AS - Application Service
// One of the main differences is that it's not transactional, unlike services in "service facade"
// Should never be called directly in a controller
@Component
public class ImageAS {
    public static final Logger logger = LogManager.getLogger(ImageAS.class);

    public ImageDTO getImageDTOById(Long imageId) {
        return new ImageDTO(); // FIXME
    }

    public Long getIdFromImageDTO(ImageDTO dto) {
        if (dto == null) {
            return null;
        }

        return dto.getId();
    }

}
