package com.weatherwear.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class WeatherService {

    private final String weatherApiKey = "885f0710ddmsh848a7201276366dp166bd8jsn6af8aeda1640";

    private String fetchCurrentWeather() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=auto%3Aip"))
                .header("X-RapidAPI-Key", weatherApiKey)
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void weatherRunner(){

        String locationWeatherJson;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode parentnode;
        try {
            locationWeatherJson = fetchCurrentWeather();
            parentnode = mapper.readTree(locationWeatherJson);
            assert parentnode != null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String weatherJson = parentnode.get("current").get("temp_c").asText();

        System.out.println("Current temperature in Celsius: " + weatherJson);
    }

}
