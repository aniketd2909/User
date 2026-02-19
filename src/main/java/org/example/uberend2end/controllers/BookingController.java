package org.example.uberend2end.controllers;

import org.example.uberend2end.adapter.BookingMapper;
import org.example.uberend2end.dtos.BookingDTO;
import org.example.uberend2end.dtos.BookingRequestDTO;
import org.example.uberend2end.dtos.BookingResponseDTO;
import org.example.uberend2end.entities.Booking;
import org.example.uberend2end.services.IBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        // Map DTO to Entity (In a real app, use a Mapper)
        BookingDTO bookingDTO= BookingMapper.toBookingDTO(bookingRequestDTO);
        Booking booking = BookingMapper.toEntity(bookingDTO);
        Booking createdBooking = bookingService.createBooking(booking);
        BookingDTO createdBookingDTO = BookingMapper.toBookingDTO(createdBooking);
        return ResponseEntity.status(201).body(BookingMapper.toBookingResponseDTO(createdBookingDTO));
    }

}
