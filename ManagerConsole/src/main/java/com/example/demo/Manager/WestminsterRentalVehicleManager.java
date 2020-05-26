package com.example.demo.Manager;

import com.example.demo.DemoApplication;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    public void functionChoices() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number Of Your Choice \n 1.Add a Vehicle\n 2.Delete Vehicle \n 3.Get All Vehicles");
        Integer userChoice = scanner.nextInt();

        if(userChoice == 1){
            addVehicle();
        }else if(userChoice == 2){
            deleteVehicle();
        }else if(userChoice == 3){
            getAllVehicles();
        }else {
            System.out.println("Please Check For Instructions Above");
        }

    }

    public void nextFunction() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1.Continue Operations 2.Quit");
        Integer choice = scanner.nextInt();
        if(choice == 1){
            functionChoices();
        }else if (choice == 2){
            System.out.println("Have a Nice day");
        }else{
            System.out.println("Please Enter a valid Input");

        }
    }

    @Override
    public void addVehicle() throws Exception {
        Scanner vehicleChoice = new Scanner(System.in);
        System.out.println("Please Enter the Type Of Vehicle to Add \n1.Bike \n2.Car");
        Integer choiceRaw = vehicleChoice.nextInt();
        if (choiceRaw == 1) {
            int validationPass = 0;
            DemoApplication demoApplication = new DemoApplication();
            Scanner vehicleAttr = new Scanner(System.in);
            System.out.println("Please Enter the attributes for the Bike \n1.color\n2.model\n3.plateNo\n4.headGearIncnclusive (true/false)\n5.storageSpace(true/false)");
            System.out.println("Please Enter the Colour Bike\n");
            String color = vehicleAttr.nextLine();
            System.out.println("Please Enter the Model Bike\n");
            String model = vehicleAttr.nextLine();
            System.out.println("Please Enter the Bike Plate No\n");
            String plateNo = vehicleAttr.nextLine();
            System.out.println("Is Head Gear Inclusive(y/n)\n");
            String headGear = vehicleAttr.nextLine();
            Boolean headGearIncnclusive = false;
            System.out.println(headGear);
            if (headGear.equalsIgnoreCase("y")) {
                validationPass = 1;
                headGearIncnclusive = true;
            } else if (headGear.equalsIgnoreCase("n")) {
                headGearIncnclusive = false;
                validationPass = 1;
            } else {
                System.out.println("Invalid Input");
                validationPass = 0;
            }

            System.out.println("Is Storage Space Inclusive(y/n)\n");
            Boolean storageSpaceIncnclusive = false;
            String storageSpace = vehicleAttr.nextLine();
            if (storageSpace.equalsIgnoreCase("y")) {
                validationPass = 1;
                storageSpaceIncnclusive = true;
            } else if (storageSpace.equalsIgnoreCase("n")) {
                validationPass = 1;
                storageSpaceIncnclusive = false;
            } else {
                System.out.println("Invalid Input");
                validationPass = 0;
            }

            if (validationPass == 1) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("color", color);
                jsonObject.put("model", model);
                jsonObject.put("plateNo", plateNo);
                jsonObject.put("headGearIncnclusive", headGearIncnclusive);
                jsonObject.put("storageSpace", storageSpaceIncnclusive);
                demoApplication.addVehicle(jsonObject, 1);
                System.out.println("Vehicle Added Successfully");
            } else {
                System.out.println("Please Re Enter Details Of the Car");
            }
            nextFunction();

        } else if (choiceRaw == 2) {
            int validationPass = 0;
            DemoApplication demoApplication = new DemoApplication();
            Scanner vehicleAttr = new Scanner(System.in);
            System.out.println("Please Enter the attributes for the Car \n1.color\n2.model\n3.plateNo\n4.Air Condition Feature (y/n)\n5.Transmission(auto/manual)");
            System.out.println("Please Enter the Colour Car\n");
            String color = vehicleAttr.nextLine();
            System.out.println("Please Enter the Model Car\n");
            String model = vehicleAttr.nextLine();
            System.out.println("Please Enter the Car Plate No\n");
            String plateNo = vehicleAttr.nextLine();
            System.out.println("Is airConditioned Inclusive(y/n)\n");
            String airConditioned = vehicleAttr.nextLine();
            Boolean airConditionInclusive = false;
            System.out.println(airConditioned);
            if (airConditioned.equalsIgnoreCase("y")) {
                validationPass = 1;
                airConditionInclusive = true;
            } else if (airConditioned.equalsIgnoreCase("n")) {
                airConditionInclusive = false;
                validationPass = 1;
            } else {
                System.out.println("Invalid Input");
                validationPass = 0;
            }

            System.out.println("Transmission Type(auto/manual)\n");
            String transmissionInclusive = "auto";
            String transmission = vehicleAttr.nextLine();
            if (transmission.equalsIgnoreCase("auto")) {
                validationPass = 1;
                transmissionInclusive = "auto";
            } else if (transmission.equalsIgnoreCase("manual")) {
                validationPass = 1;
                transmissionInclusive = "manual";
            } else {
                System.out.println("Invalid Input");
                validationPass = 0;
            }

            if (validationPass == 1) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("color", color);
                jsonObject.put("model", model);
                jsonObject.put("seatCapacity",4);
                jsonObject.put("airConditioned", airConditionInclusive);
                jsonObject.put("transmission", transmissionInclusive);
                jsonObject.put("plateNo", plateNo);
                demoApplication.addVehicle(jsonObject, 2);
                System.out.println("Vehicle Added Successfully");
            } else {
                System.out.println("Please Re Enter Details Of the Car");
            }

            nextFunction();

        }

    }

    @Override
    public void deleteVehicle() throws Exception {
        DemoApplication demoApplication = new DemoApplication();
        Scanner vehicleType = new Scanner(System.in);
        System.out.println("Enter \n 1.Delete Bike \n Delete Car");
        Integer VType = vehicleType.nextInt();

        Scanner vehicleId = new Scanner(System.in);
        System.out.println("Please Enter the Respective Vehicle's Id, If your not sure You can check for All Vehicle Details");
        String vehicleIdRaw = vehicleId.nextLine();

        if(VType == 1){
            demoApplication.deleteVehicle(vehicleIdRaw,1);
        }else if(VType == 2){
            demoApplication.deleteVehicle(vehicleIdRaw,2);
        }else {
            System.out.println("Invalid Option");
        }

        nextFunction();

    }

    @Override
    public void getAllVehicles() throws Exception {
        DemoApplication demoApplication = new DemoApplication();
        demoApplication.getAllVehicles();

        nextFunction();


    }
}
