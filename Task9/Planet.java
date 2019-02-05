package core;

import java.util.Objects;

public class Planet extends StarSystem {
	private int countOfSatellites;
	private boolean isLife;
	private char space = ' ';

	public Planet() {

	}

	public Planet(int countOfSatellites, boolean isLife) {
		super();
		this.countOfSatellites = countOfSatellites;
		this.isLife = isLife;
	}

	public void printCountOfSatellites() {
		System.out.println("Amount of satellites: " + countOfSatellites);
	}

	public void printIsLife() {
		System.out.println(isLife ? "Habitable planet!" : "Uninhabited planet");
	}

	@Override
	public void printAllInfo() {
		System.out.println(
				"All Information about Planet: " + super.getStarSystemAge() + space + super.getStarSystemName());
		printCountOfSatellites();
		printIsLife();
	}

	@Override
	public void printStarSystemInfo() {
		System.out.println("This is object Planet!");
		System.out.println("Star System Information: " + super.getStarSystemAge() + space + super.getStarSystemName());

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(countOfSatellites);
	}

	@Override
	public String toString() {
		return "Planet: {countOfSatellites = " + countOfSatellites + "	isLife?: " + isLife + "}";
	}
}
