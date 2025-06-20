package com.guestDetailsService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "registration_details")
public class RegistrationForm {

    @Id
    private String id;

    private Guest primaryGuest;

    private List<FamilyMember> familyMembers;

    private String checkInTime;
    private String checkOutTime;

    private String checkInDate;
    private String checkOutDate;

    private String stayDuration; // e.g., "12hr"
    private double farePerNight;
    private double advancePayment;
    private double remainingPayment;

    private String companyId;

    private boolean extraBed;
    private double extraBedPrice;

    private MealPlan mealPlan;

    private boolean wakeUpCall;
    private String wakeUpCallTime;
}
