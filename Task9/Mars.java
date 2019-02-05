package core;

import java.util.Objects;

public class Mars extends Planet {
	private String color;
	private int weight;

	public Mars() {

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void printcolor() {
		System.out.println("Mars color: " + color);
	}

	public void printSatellites() {
		System.out.println("Mars's weight: " + weight);
	}

	public int hashCode() {
		return Objects.hashCode(color);
	}

	public String toString() {
		return "Mars: {color: " + color + ",	weight = " + weight + "}";
	}
}
