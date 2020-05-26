package com.example.demo;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class DemoApplication {

    // one instance, reuse
    private final OkHttpClient httpClient = new OkHttpClient();

    public void getAllVehicles() throws Exception {

        Request requestbikes = new Request.Builder()
                .url("http://localhost:9099/bikes/")
                .build();

        try (Response responsebikes = httpClient.newCall(requestbikes).execute()) {

            if (!responsebikes.isSuccessful()) throw new IOException("Unexpected code " + responsebikes);

            // Get response body
            System.out.println(responsebikes.body().string());

        }

        Request requestCars = new Request.Builder()
                .url("http://localhost:9099/cars/")
                .build();

        try (Response responseCars = httpClient.newCall(requestCars).execute()) {

            if (!responseCars.isSuccessful()) throw new IOException("Unexpected code " + responseCars);

            // Get response body
            System.out.println(responseCars.body().string());


        }catch (JSONException e){
            System.out.println(e.getMessage());
        }


    }

    public void addVehicle(JSONObject requestBodyRaw, Integer type) throws Exception {
        String sendUrl = "";
        String successResponse = "";
        if (type == 1) {
            sendUrl = "http://localhost:9099/bikes";
            successResponse = "Bike Successfully Added";
        }else if(type == 2){
            sendUrl = "http://localhost:9099/cars";
            successResponse = "Car Successfully Added";

        }


        MediaType contentType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(contentType, String.valueOf(requestBodyRaw));
        Request request = new Request.Builder()
                .url(sendUrl)
                .post(requestBody)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            // Get response body
            System.out.println(response.body().string());
        }




    }

    public void deleteVehicle(String vehicleId, Integer type) throws IOException {
        String sendUrl = "";
        String successResponse = "";
        if (type == 1) {
            sendUrl = "http://localhost:9099/bikes/" + vehicleId;
            successResponse = "Bike Successfully Deleted";

            if (type == 2) {
                sendUrl = "http://localhost:9099/cars" + vehicleId;
                successResponse = "Car Successfully Deleted";
            }

            Request request = new Request.Builder()
                    .url(sendUrl)
                    .delete()
                    .build();

            try (Response response = httpClient.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                // Get response body
                //System.out.println(response.body().string());
                System.out.println(successResponse);
            }


        }


    }

}