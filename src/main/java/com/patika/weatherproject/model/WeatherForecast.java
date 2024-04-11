package com.patika.weatherproject.model;


import java.util.List;

public class WeatherForecast {
    private List<WeatherApiResponse> list;

    public List<WeatherApiResponse> getList() {
        return list;
    }

    public void setList(List<WeatherApiResponse> list) {
        this.list = list;
    }
}
