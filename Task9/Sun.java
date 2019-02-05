package core;

import java.util.Objects;

public class Sun extends Star {
	private String type;
	private int countOfPlanet;

	public Sun() {

	}

	public Sun(int temperature, int bright) {
		super(temperature, bright);
	}

	public Sun(int temperature, int bright, String type) {
		this(temperature, bright);
		this.type = type;
	}

	public Sun(int temperature, int bright, String type, int countOfPlanet) {
		this(temperature, bright, type);
		this.countOfPlanet = countOfPlanet;
	}

	public void printType() {
		System.out.println("Type: " + type);
	}

	public void printCountOfPlanet() {
		System.out.println("Amount of planet in galaktika: " + countOfPlanet);
	}

	public int hashCode() {
		return Objects.hashCode(type);
	}

	public String toString() {
		return "Sun: {type: " + type + ",	countOfPlanet = " + countOfPlanet + "}";
	}
}
