package com.guestDetailsService.controller;

import com.guestDetailsService.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guestDetailsService.entity.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*")
public class DashBoardController {

    @Autowired
    private DashBoardService service;

    private static final Logger log = LoggerFactory.getLogger(DashBoardController.class);

    @GetMapping("/room-statuses")
    public List<RegistrationForm> getRoomStatuses() {
        return service.getRoomStatuses();
    }

    @PutMapping("/room-statuses/{roomNumber}")
    public RegistrationForm updateRoomStatus(@PathVariable String roomNumber, @RequestBody String statusRequest) {
        return service.updateRoomStatus(roomNumber, statusRequest);
    }

    @GetMapping("/stats")
    public long getTotalBookings() {
        return service.getTotalBookings();
    }
}
