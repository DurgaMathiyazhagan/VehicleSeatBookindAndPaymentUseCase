package com.usecase.bookingservice.service;

import com.usecase.bookingservice.entity.Seat;
import com.usecase.bookingservice.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAvailableSeats(Long busId) {
        return seatRepository.findByBusIdAndIsAvailable(busId, true);
    }

    public Seat bookSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        if (!seat.isAvailable()) {
            throw new RuntimeException("Seat is already booked");
        }
        seat.setAvailable(false);
        return seatRepository.save(seat);
    }
}
