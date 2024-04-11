package com.patika.weatherproject.controller;

import com.patika.weatherproject.exception.WeatherException;
import com.patika.weatherproject.model.DailyWeather;
import com.patika.weatherproject.model.WeatherForecast;
import com.patika.weatherproject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class WeatherController {

    private String apiKey = "b884364f33fc2d775a7cf068e19cdae1";

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather") // istek örneği : localhost:8080/weather?city=Ankara&day=3
    public List<DailyWeather> getWeather(@RequestParam String city, @RequestParam Integer day) {
        try{
            String openWeatherMapUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" // Gelen tüm veriyi çekmek için: forecast
                    + city
                    + "&appid="
                    + apiKey
                    + "&units=metric"; // Sıcaklık değerinin Celsius olması için: metric

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(openWeatherMapUrl, WeatherForecast.class);

            if(response.getStatusCode() == HttpStatus.OK){
                return weatherService.getWeather(response.getBody(),day);
            }
            else{
                return null;
            }
        }
        catch (Exception e) {
            throw new WeatherException("Exception: " + e.getLocalizedMessage());
        }

    }
}
