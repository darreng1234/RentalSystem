package com.example.demo.service.Schedule;

import com.example.demo.dto.Bike;
import com.example.demo.dto.Customer;
import com.example.demo.dto.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.Bike.BikeServiceImp;
import com.example.demo.service.Car.CarServiceImp;
import com.example.demo.service.Customer.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleServiceImp implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    CustomerServiceImp customerServiceImp;
    @Autowired
    CarServiceImp carServiceImp;
    @Autowired
    BikeServiceImp bikeServiceImp;


    @Override
    public List<Schedule> getAllBookings() {
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> getBookingById(UUID scheduleId) {
        if (scheduleRepository.findById(scheduleId).isPresent()) {
            return scheduleRepository.findById(scheduleId);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public String addBooking(Schedule schedule) {
        if(!vehicleExists(schedule)){
            return "Vehicle Plate Number is Non Existant ! Please Check and Try again";
        }else {
            UUID scheduleId = UUID.randomUUID();
            scheduleRepository.save(new Schedule(scheduleId,schedule.getBookingStDate(),schedule.getBookingEndDate(),schedule.getCustUniqueIdentifier(),schedule.getCustName(),schedule.getPlateNo(),schedule.getVehicleColor(),schedule.getVehicleModel(),schedule.getEligibleToDrive(),schedule.getType()
            ));

            if(!customerExists(schedule.getCustUniqueIdentifier())){
                UUID tempUUID = UUID.randomUUID();
                Customer customer = new Customer(tempUUID,schedule.getCustName(),schedule.getEligibleToDrive(),schedule.getCustUniqueIdentifier());
                customerServiceImp.addCustomer(customer);
            }

            updateVehicleBookingStatus(schedule);

            return "Booking Successfully added";

        }



    }

    @Override
    public void updateBooking(UUID scheduleId, Schedule schedule) {
        if (scheduleRepository.findById(scheduleId).isPresent()) {
            scheduleRepository.save(schedule);
        }

    }

    @Override
    public void deleteBooking(UUID scheduleId) {
        if (scheduleRepository.findById(scheduleId).isPresent()) {
            scheduleRepository.deleteById(scheduleId);
        }
    }

    @Override
    public Boolean customerExists(String uniqueIdentifier) {
        if(customerServiceImp.customerExists(uniqueIdentifier)){
            return true;
        }

        return false;
    }

    //Type =1 => Car //Type = 2 => Bike
    public Boolean updateVehicleBookingStatus(Schedule schedule){
        if(schedule.getType() == 1){
            carServiceImp.updateStatus(schedule.getPlateNo());
            return true;
        }else if(schedule.getType() == 2){
            bikeServiceImp.updateStatus(schedule.getPlateNo());
            return true;
        }else {
            System.out.println("There are no models for this type");
            return false;
        }

    }

    public Boolean vehicleExists(Schedule schedule){

        if(schedule.getType() == 1 && !carServiceImp.getCarByPlateNo(schedule.getPlateNo()).isPresent()){
            return false;
        }else if(schedule.getType() == 2 && !bikeServiceImp.getBikeByPlateNo(schedule.getPlateNo()).isPresent()){
            return false;
        }
        return true;
    }


}
