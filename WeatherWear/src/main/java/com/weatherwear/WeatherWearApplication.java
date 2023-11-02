package com.weatherwear;

import com.weatherwear.service.LocationService;

public class WeatherWearApplication {

    public static void main (String [] args){

        System.out.println("Hello World");
        System.out.println("Getting location...");

        LocationService locationService = new LocationService();
        try {
            locationService.fetchMe();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
