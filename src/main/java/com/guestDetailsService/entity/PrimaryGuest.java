package com.guestDetailsService.entity;

import lombok.Data;

@Data
public class PrimaryGuest  {
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;  // Store as ISO string or convert to LocalDate if needed
    private String mobile;
    private String address;
    private String identityProof;
    private String identityNumber;
    private String identityFileBase64; // Store file path or URL if uploaded
}
