package com.guestDetailsService.controller;

import com.guestDetailsService.entity.PrimaryGuest;
import com.guestDetailsService.entity.RegistrationForm;
import com.guestDetailsService.service.GuestRegistrationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/guest-registration")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GuestRegistrationController {

    @Autowired
    private final GuestRegistrationService service;

    private static final Logger log = LoggerFactory.getLogger(GuestRegistrationController.class);

    @PostMapping(consumes = {"multipart/form-data"})
    public RegistrationForm create(
            @RequestPart("form") RegistrationForm form,
            @RequestPart(value = "identityFile", required = false) MultipartFile identityFile
    ) throws IOException {

        log.info("Received request to create guest registration");

        if (identityFile != null && !identityFile.isEmpty()) {
            log.info("Processing identity file: {}", identityFile.getOriginalFilename());

            String contentType = identityFile.getContentType(); // e.g., image/png
            String prefix = "data:" + contentType + ";base64,";
            String base64 = Base64.getEncoder().encodeToString(identityFile.getBytes());
            String fullBase64 = prefix + base64;

            PrimaryGuest guest = form.getPrimaryGuest();
            guest.setIdentityFileBase64(fullBase64);
            form.setPrimaryGuest(guest);

            log.info("Identity file encoded and added to guest");
        }

        RegistrationForm savedForm = service.save(form);
        log.info("Guest registration saved with ID: {}", savedForm.getId());

        return savedForm;
    }

    @GetMapping
    public List<RegistrationForm> getAll() {
        log.info("Fetching all guest registrations");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationForm getById(@PathVariable String id) {
        log.info("Fetching guest registration by ID: {}", id);
        return service.findById(id)
                .orElseThrow(() -> {
                    log.warn("Guest registration not found for ID: {}", id);
                    return new RuntimeException("Guest not found");
                });
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public RegistrationForm update(
            @PathVariable String id,
            @RequestPart("form") RegistrationForm form,
            @RequestPart(value = "identityFile", required = false) MultipartFile identityFile
    ) throws IOException {
        log.info("Updating guest registration with ID: {}", id);

        if (identityFile != null && !identityFile.isEmpty()) {
            log.info("Processing updated identity file: {}", identityFile.getOriginalFilename());

            String contentType = identityFile.getContentType(); // e.g., image/png
            String prefix = "data:" + contentType + ";base64,";
            String base64 = Base64.getEncoder().encodeToString(identityFile.getBytes());
            String fullBase64 = prefix + base64;

            PrimaryGuest guest = form.getPrimaryGuest();
            guest.setIdentityFileBase64(fullBase64);
            form.setPrimaryGuest(guest);

            log.info("Updated identity file encoded and set.");
        }

        return service.update(id, form);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        log.info("Deleting guest registration with ID: {}", id);
        service.delete(id);
        log.info("Guest registration deleted for ID: {}", id);
    }

    @PutMapping("/update-status/{id}/{status}")
    public ResponseEntity<String> updateGuestStatus(
            @PathVariable String id,
            @PathVariable String status // This matches FormData from frontend
    ) {
        String result = service.updateStatus(id, status);
        return ResponseEntity.ok(result);
    }

}
