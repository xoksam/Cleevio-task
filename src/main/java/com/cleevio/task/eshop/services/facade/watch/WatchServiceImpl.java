package com.cleevio.task.eshop.services.facade.watch;

import com.cleevio.task.eshop.common.dto.WatchDTO;
import com.cleevio.task.eshop.common.dto.WatchDetailDTO;
import com.cleevio.task.eshop.mapper.WatchMapper;
import com.cleevio.task.eshop.services.dao.WatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchServiceImpl implements WatchService {
    @Autowired
    private WatchDao watchDao;

    @Autowired
    private WatchMapper watchMapper;

    @Override
    public WatchDTO getWatchById(Long watchId) {
        var watch = watchDao.findWatchById(watchId);

        return watchMapper.mapWatchToDto(watch);
    }

    @Override
    public WatchDetailDTO getWatchDetailById(Long watchId) {
        var watch = watchDao.findWatchById(watchId);

        return watchMapper.mapWatchToDetailDto(watch);
    }
}
