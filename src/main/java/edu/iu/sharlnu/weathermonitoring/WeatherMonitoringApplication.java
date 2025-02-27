package edu.iu.sharlnu.weathermonitoring;

import edu.iu.sharlnu.weathermonitoring.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherMonitoringApplication {

	public static void main(String[] args) {

		WeatherData weatherData = new WeatherData();

		CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		// Simulate new weather measurements
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);

		// Unsubscribe one display as an example
		weatherData.removeObserver(statisticsDisplay);

		// Simulate more measurements after unsubscribing statistics display
		weatherData.setMeasurements(85, 75, 29.5f);



	}

}
