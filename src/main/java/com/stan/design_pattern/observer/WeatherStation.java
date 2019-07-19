package com.stan.design_pattern.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay ccd = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay sd = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(0,0,0);
        weatherData.setMeasurements(1,1,1);

    }

}
