package core;

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
		final int prime = 31;
		return (int) (prime * countOfSatellites + (isLife ? 1 : 0));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet planet = (Planet) obj;
		if (countOfSatellites != planet.countOfSatellites)
			return false;
		if (isLife != planet.isLife)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {countOfSatellites = " + countOfSatellites + "	isLife?: " + isLife + "}";
	}

}
