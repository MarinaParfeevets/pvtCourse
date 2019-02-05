package core;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (distanceToSun);
		result = prime * result + (int) (population);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Earth earth = (Earth) obj;
		if (distanceToSun != earth.distanceToSun)
			return false;
		if (population != earth.population)
			return false;
		return true;
	}

	public String toString() {
		return getClass().getName() + " {population = " + population + ",	distanceToSun = " + distanceToSun + "}";
	}
}
