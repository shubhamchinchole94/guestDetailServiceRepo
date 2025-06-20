package com.guestDetailsService.repository;

import com.guestDetailsService.entity.RegistrationForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRegistrationRepo extends MongoRepository<RegistrationForm, String> {

}

