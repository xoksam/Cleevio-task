package com.cleevio.task.eshop.controller;

import com.cleevio.task.eshop.common.ApiConstants;
import com.cleevio.task.eshop.common.dto.WatchDTO;
import com.cleevio.task.eshop.common.dto.WatchDetailDTO;
import com.cleevio.task.eshop.services.facade.watch.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.API_PREFIX + "/watch")
public class WatchController {
    @Autowired
    private WatchService watchService;

    @GetMapping("/{watchId}")
    public WatchDTO getWatchById(@PathVariable Long watchId) {
        return watchService.getWatchById(watchId);
    }

    @GetMapping("/{watchId}/detail")
    public WatchDTO getWatchDetailById(@PathVariable Long watchId) {
        return watchService.getWatchDetailById(watchId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public WatchDetailDTO saveWatchDetail(@RequestBody WatchDetailDTO dto) {
        return watchService.saveWatchDetail(dto);
    }
}
