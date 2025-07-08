package com.guestDetailsService.repository;

import com.guestDetailsService.entity.RoomTransfer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RoomTransferRepository extends MongoRepository<RoomTransfer, String> {
    List<RoomTransfer> findByBookingId(String bookingId);
}
