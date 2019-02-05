package core;

import java.util.Objects;

public class Star extends StarSystem {
	private int temperature;
	private int bright;
	private char space = ' ';

	public Star() {

	}

	public Star(int temperature) {
		super();
		this.temperature = temperature;
	}

	public Star(int temperature, int bright) {
		super();
		this.temperature = temperature;
		this.bright = bright;
	}

	public void printTemperature() {
		System.out.println("Star's temperature: " + temperature);
	}

	public void printBright() {
		System.out.println("Star's bright: " + bright);
	}

	@Override
	public void printAllInfo() {
		System.out
				.println("All Information about Star: " + super.getStarSystemAge() + space + super.getStarSystemName());
		printTemperature();
		printBright();
	}

	@Override
	public void printStarSystemInfo() {
		System.out.println("This is object Star!");
		System.out.println("Star System Information: " + super.getStarSystemAge() + space + super.getStarSystemName());

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(temperature);
	}

	@Override
	public String toString() {
		return "Star: {temperature = " + temperature + ",	bright = " + bright + "}";
	}

}
