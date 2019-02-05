package core;

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
	public String toString() {
		return getClass().getName() + " {temperature = " + temperature + ",	bright = " + bright + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bright;
		result = prime * result + temperature;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Star star = (Star) obj;
		if (bright != star.bright)
			return false;
		if (temperature != star.temperature)
			return false;
		return true;
	}

}
