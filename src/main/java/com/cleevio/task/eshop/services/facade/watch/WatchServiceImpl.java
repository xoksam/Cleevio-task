package com.cleevio.task.eshop.services.facade.watch;

import com.cleevio.task.eshop.common.dto.WatchDTO;
import com.cleevio.task.eshop.common.dto.WatchDetailDTO;
import com.cleevio.task.eshop.common.exceptions.EntityNotFoundException;
import com.cleevio.task.eshop.mapper.WatchMapper;
import com.cleevio.task.eshop.model.watch.Watch;
import com.cleevio.task.eshop.services.dao.WatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WatchServiceImpl implements WatchService {
    @Autowired
    private WatchDao watchDao;

    @Autowired
    private WatchMapper watchMapper;

    @Override
    public WatchDTO getWatchById(Long watchId) {
        var watch = watchDao.findWatchById(watchId);

        if (watch == null) {
            throw new EntityNotFoundException(Watch.class, "id", watchId);
        }

        return watchMapper.mapWatchToDto(watch);
    }

    @Override
    public WatchDetailDTO getWatchDetailById(Long watchId) {
        var watch = watchDao.findWatchById(watchId);

        if (watch == null) {
            throw new EntityNotFoundException(Watch.class, "id", watchId);
        }

        return watchMapper.mapWatchToDetailDto(watch);
    }

    @Override
    public WatchDetailDTO saveWatchDetail(WatchDetailDTO watchDetailDTO) {
        Watch watch = null;
        var watchId = watchDetailDTO.getId();

        if (watchId != null) {
            watch = watchDao.find(Watch.class, watchId);
            if (watch == null) {
                throw new EntityNotFoundException(Watch.class, "id", watchId);
            }

            if (watchDetailDTO.getCreated() == null) {
                watchDetailDTO.setCreated(watch.getCreated());
            }
        }

        // The entity gets modified here
        watch = watchMapper.mapWatchDetailDtoToEntity(watchDetailDTO, watch);

        // New
        if (watch.getId() == null) {
            watchDao.persist(watch);
        }
        // Else it's updated in the mapper
        // Since the service is @Transactional, there's no merge or flush required for the changes to apply

        return watchMapper.mapWatchToDetailDto(watch); // Return the changed DTO
    }
}
