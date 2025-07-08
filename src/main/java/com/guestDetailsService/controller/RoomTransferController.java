package com.guestDetailsService.controller;

import com.guestDetailsService.entity.RoomTransfer;
import com.guestDetailsService.service.RoomTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room-transfers")
@CrossOrigin(origins = "*")
public class RoomTransferController {

    @Autowired
    private RoomTransferService service;

    @PostMapping
    public RoomTransfer createTransfer(@RequestBody RoomTransfer transfer) {
        return service.createTransfer(transfer);
    }

    @GetMapping
    public List<RoomTransfer> getAllTransfers() {
        return service.getAllTransfers();
    }

    @GetMapping("/{id}")
    public Optional<RoomTransfer> getTransferById(@PathVariable String id) {
        return service.getTransferById(id);
    }

    @GetMapping("/booking/{bookingId}")
    public List<RoomTransfer> getTransfersByBookingId(@PathVariable String bookingId) {
        return service.getTransfersByBookingId(bookingId);
    }

    @PutMapping("/{id}")
    public RoomTransfer updateTransfer(@PathVariable String id, @RequestBody RoomTransfer updatedTransfer) {
        return service.updateTransfer(id, updatedTransfer);
    }

    @DeleteMapping("/{id}")
    public void deleteTransfer(@PathVariable String id) {
        service.deleteTransfer(id);
    }
}
