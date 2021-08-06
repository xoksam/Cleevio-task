package com.cleevio.task.eshop.controller;

import com.cleevio.task.eshop.common.ApiConstants;
import com.cleevio.task.eshop.common.dto.WatchDTO;
import com.cleevio.task.eshop.services.facade.watch.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
