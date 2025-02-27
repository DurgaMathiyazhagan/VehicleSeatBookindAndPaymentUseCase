package com.usecase.bookingservice.controller;

import com.usecase.bookingservice.entity.Seat;
import com.usecase.bookingservice.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/available/{busId}")
    public List<Seat> getAvailableSeats(@PathVariable Long busId) {
        return seatService.getAvailableSeats(busId);
    }

    @PostMapping("/book/{seatId}")
    public Seat bookSeat(@PathVariable Long seatId) {
        return seatService.bookSeat(seatId);
    }
}