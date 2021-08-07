package com.cleevio.task.eshop.services.facade.watch;

import com.cleevio.task.eshop.common.dto.WatchDTO;
import com.cleevio.task.eshop.common.dto.WatchDetailDTO;
import org.springframework.transaction.annotation.Transactional;


// Important!
// All services that are on a "facade" are transactional
@Transactional
public interface WatchService {
    WatchDTO getWatchById(Long watchId);

    WatchDetailDTO getWatchDetailById(Long watchId);

    WatchDetailDTO saveWatchDetail(WatchDetailDTO watchDetailDTO);
}
