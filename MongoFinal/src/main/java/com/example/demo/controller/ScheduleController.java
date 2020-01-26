package com.example.demo.controller;

import com.example.demo.dto.Schedule;
import com.example.demo.service.Schedule.ScheduleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ScheduleController {

    @Autowired
    ScheduleServiceImp scheduleServiceImp;

    @GetMapping("/bookings")
    public List<Schedule> getAllBookings() {
        return scheduleServiceImp.getAllBookings();
    }

    @GetMapping("/bookings/{scheduleId}")
    Optional<Schedule> getBookingById(@PathVariable UUID scheduleId) {
        return scheduleServiceImp.getBookingById(scheduleId);
    }

    @PostMapping("/bookings")
    public String addBooking(@RequestBody Schedule schedule) throws IncorrectResultSizeDataAccessException {
        return scheduleServiceImp.addBooking(schedule);
    }

    @PutMapping("bookings/{scheduleId}")
    public void updateBooking(@PathVariable UUID scheduleId, @RequestBody Schedule schedule) {
        scheduleServiceImp.updateBooking(scheduleId, schedule);
    }

    @DeleteMapping("/bookings/{scheduleId}")
    public void deleteBooking(@PathVariable UUID scheduleId) {
        scheduleServiceImp.deleteBooking(scheduleId);
    }

}
