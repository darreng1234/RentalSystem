package com.example.demo.repository;

import com.example.demo.dto.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ScheduleRepository extends MongoRepository<Schedule, UUID> {

}
