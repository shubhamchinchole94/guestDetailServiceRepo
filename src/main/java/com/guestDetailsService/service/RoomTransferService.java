package com.guestDetailsService.service;

import com.guestDetailsService.entity.RoomTransfer;
import com.guestDetailsService.repository.RoomTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTransferService {

    @Autowired
    private RoomTransferRepository repository;

    public RoomTransfer createTransfer(RoomTransfer transfer) {
        return repository.save(transfer);
    }

    public List<RoomTransfer> getAllTransfers() {
        return repository.findAll();
    }

    public Optional<RoomTransfer> getTransferById(String id) {
        return repository.findById(id);
    }

    public List<RoomTransfer> getTransfersByBookingId(String bookingId) {
        return repository.findByBookingId(bookingId);
    }

    public RoomTransfer updateTransfer(String id, RoomTransfer updatedTransfer) {
        updatedTransfer.setId(id);
        return repository.save(updatedTransfer);
    }

    public void deleteTransfer(String id) {
        repository.deleteById(id);
    }
}

