package com.patika.weatherproject.controller;

import com.patika.weatherproject.model.DailyWeather;
import com.patika.weatherproject.model.WeatherApiResponse;
import com.patika.weatherproject.model.WeatherForecast;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {

    private final String apiKey = "b884364f33fc2d775a7cf068e19cdae1";

    @GetMapping("/weather") // istek örneği : localhost:8080/weather?city=Ankara&day=3
    public List<DailyWeather> getWeather(@RequestParam String city, @RequestParam Integer day) {
        String openWeatherMapUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" // Gelen tüm veriyi çekmek için: forecast
                + city
                + "&appid="
                + apiKey
                + "&units=metric"; // Sıcaklık değerinin Celsius olması için: metric

        RestTemplate restTemplate = new RestTemplate();

        WeatherForecast weatherForecast = restTemplate.getForObject(openWeatherMapUrl, WeatherForecast.class);

        List<DailyWeather> weathers = new ArrayList<>();

        LocalDate currentDay = null;

        for (WeatherApiResponse forecastData : weatherForecast.getList()) {
            if(weathers.size() < day) {
                // Çekilen verideki tarih değerleri long olduğu için, bir tarih değerine dönüştürüyoruz
                Instant instant = Instant.ofEpochSecond(forecastData.getDt());
                LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate forecastDate = dateTime.toLocalDate();

                if(currentDay == null) // Şuanki gün değeri çekilen verideki ilk değerdir
                    currentDay = forecastDate;

                if (forecastDate.isEqual(currentDay)) { // Çekilen veride aynı günü kapsayan birden fazla değer olduğu için yalnızca 1 tanesini al
                    DailyWeather weather = new DailyWeather();
                    weather.setDate(forecastData.getDt());
                    weather.setHumidity(forecastData.getMain().getHumidity());
                    weather.setTemp(forecastData.getMain().getTemp() + "°C");
                    weather.setTemp_min(forecastData.getMain().getTemp_min() + "°C");
                    weather.setTemp_max(forecastData.getMain().getTemp_max() + "°C");

                    currentDay = currentDay.plusDays(1); // Çekilen gün değeri arttırıldı
                    weathers.add(weather);
                }
            }
            else
                break;
        }

        return weathers;
    }
}
