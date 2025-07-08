package com.guestDetailsService.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document(collection = "room_transfers")
public class RoomTransfer {
    @Id
    private String id;
    private String bookingId;
    private String fromRoom;
    private String toRoom;
    private String reason;
    private String remarks;
    private LocalDateTime transferredAt;
    private String transferredBy;
}
