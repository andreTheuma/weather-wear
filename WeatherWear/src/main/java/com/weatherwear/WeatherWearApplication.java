package com.weatherwear;

import com.weatherwear.service.LocationService;
import com.weatherwear.service.WeatherService;

public class WeatherWearApplication {

    public static void main (String [] args){

        System.out.println("Hello World");
        System.out.println("Getting location...");


        LocationService locationService = new LocationService();
        WeatherService weatherService = new WeatherService();
        try {
            locationService.locationRunner();
            weatherService.weatherRunner();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
