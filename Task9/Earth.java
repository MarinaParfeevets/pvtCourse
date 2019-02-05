package core;

import java.util.Objects;

public class Earth extends Planet {

	private long population;
	private long distanceToSun;

	public Earth() {

	}

	public void printPopulation() {
		System.out.println("Population is " + population + " people");
	}

	public void printDistanceToSun() {
		System.out.println("Distance to Earth: " + distanceToSun + " km");
	}

	public int hashCode() {
		return Objects.hashCode(population);
	}

	public String toString() {
		return "Earth: {population = " + population + ",	distanceToSun = " + distanceToSun + "}";
	}
}
