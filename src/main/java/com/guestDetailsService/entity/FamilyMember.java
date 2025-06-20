package com.guestDetailsService.entity;

import lombok.Data;

@Data
public class FamilyMember {
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;  // Store as string or LocalDate
    private String relation;
}
