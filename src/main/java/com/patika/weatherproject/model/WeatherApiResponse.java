package com.patika.weatherproject.model;

public class WeatherApiResponse {
    private long dt;
    private MainWeather main;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public MainWeather getMain() {
        return main;
    }

    public void setMain(MainWeather main) {
        this.main = main;
    }
}
