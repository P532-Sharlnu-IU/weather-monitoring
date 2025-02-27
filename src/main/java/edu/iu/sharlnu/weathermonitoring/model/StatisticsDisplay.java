package edu.iu.sharlnu.weathermonitoring.model;

import edu.iu.sharlnu.weathermonitoring.model.Observer;

import java.util.*;

public class StatisticsDisplay implements Observer {
    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0;
    private int numReadings = 0;

    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this); // Subscribe to weather data
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override
    public String name() {
        return "Statistics Display";
    }

    @Override
    public String id() {
        return "";
    }

    public void display() {
        System.out.println("Weather Stats");
        System.out.println("Avg. temp: " + (tempSum / numReadings));
        System.out.println("Min. temp: " + minTemp);
        System.out.println("Max. temp: " + maxTemp);
    }
}