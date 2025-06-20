package com.guestDetailsService.service;

import com.guestDetailsService.entity.RegistrationForm;
import com.guestDetailsService.repository.GuestRegistrationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestRegistrationService {

    private final GuestRegistrationRepo repo;

    public RegistrationForm save(RegistrationForm form) {
        log.info("Saving new guest registration");
        RegistrationForm saved = repo.save(form);
        log.info("Guest registration saved with ID: {}", saved.getId());
        return saved;
    }

    public List<RegistrationForm> findAll() {
        log.info("Retrieving all guest registrations");
        List<RegistrationForm> registrations = repo.findAll();
        log.info("Total registrations found: {}", registrations.size());
        return registrations;
    }

    public Optional<RegistrationForm> findById(String id) {
        log.info("Searching for guest registration with ID: {}", id);
        Optional<RegistrationForm> form = repo.findById(id);
        if (form.isPresent()) {
            log.info("Guest registration found for ID: {}", id);
        } else {
            log.warn("Guest registration NOT found for ID: {}", id);
        }
        return form;
    }

    public void delete(String id) {
        log.info("Deleting guest registration with ID: {}", id);
        repo.deleteById(id);
        log.info("Deleted guest registration with ID: {}", id);
    }

    public RegistrationForm update(String id, RegistrationForm updatedForm) {
        log.info("Updating guest registration with ID: {}", id);
        updatedForm.setId(id);
        RegistrationForm saved = repo.save(updatedForm);
        log.info("Guest registration updated for ID: {}", saved.getId());
        return saved;
    }
}
