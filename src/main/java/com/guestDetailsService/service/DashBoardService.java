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
public class DashBoardService {

    private final GuestRegistrationRepo repository;

    public List<RegistrationForm> getRoomStatuses() {
        return repository.findAll(); // You can filter here if needed
    }

    public RegistrationForm updateRoomStatus(String roomNumber, String status) {
        Optional<RegistrationForm> optional = repository.findAll().stream()
                .filter(reg -> roomNumber.equals(reg.getRoomNumber()))
                .findFirst();

        if (optional.isPresent()) {
            RegistrationForm form = optional.get();
            form.setStatus(status);
            return repository.save(form);
        }
        return null;
    }

    public long getTotalBookings() {
        return repository.count();
    }

}
