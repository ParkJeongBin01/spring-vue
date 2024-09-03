package org.scoula.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main{
	private double temp;
	@JsonProperty("temp_min")
	private double tempMin;
	private int grndLevel;
	private int humidity;
	private int pressure;
	private int seaLevel;
	@JsonProperty("feels_like")
	private double feelsLike;
	@JsonProperty("temp_max")
	private double tempMax;
}