package com.weatherwear.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocationService {

//  EXPIRES 2023-11-16
    private final String weatherApiKey = "cdd91e24ddc04644940162408230211";


    public void fetchMe() throws IOException, InterruptedException {

        String hostIp = InetAddress.getLocalHost().getHostAddress();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/ip.json?q="+hostIp))
                .header("X-RapidAPI-Key", weatherApiKey)
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }


}
