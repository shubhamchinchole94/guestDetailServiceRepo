package com.guestDetailsService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Document(collection = "registration_details")
public class RegistrationForm {

    @Id
    private String id;

    private PrimaryGuest primaryGuest;
    private List<FamilyMember> familyMembers;

    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private String stayDuration;           // e.g. "12hr"
    private String farePerNight;
    private String advancePayment;
    private String remainingPayment;

    private String companyId;

    private boolean extraBed;
    private String extraBedPrice;

    private MealPlan mealPlan;

    private String wakeUpCall;            // flag if a wake‑up call is requested
    private LocalTime wakeUpCallTime;
    private String status;
    private String totalGuests;
    private String roomNumber;
}
