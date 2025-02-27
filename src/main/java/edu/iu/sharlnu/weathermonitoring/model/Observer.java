package edu.iu.sharlnu.weathermonitoring.model;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
    String name();
    String id();
}
