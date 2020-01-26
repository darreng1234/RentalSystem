package com.example.demo.service.Schedule;

import com.example.demo.dto.Customer;
import com.example.demo.dto.Schedule;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScheduleService {

    List<Schedule> getAllBookings();

    Optional<Schedule> getBookingById(UUID scheduleId);

    String addBooking(Schedule schedule);

    void updateBooking(UUID scheduleId, Schedule schedule);

    void deleteBooking(UUID scheduleId);

    Boolean customerExists(String uniqueIdentifier);

}
