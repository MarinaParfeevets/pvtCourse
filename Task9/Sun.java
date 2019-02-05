package core;

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
		final int prime = 31;
		return (int) (super.hashCode() + prime * countOfPlanet + (type == null ? 0 : type.hashCode()));
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
		Sun sun = (Sun) obj;
		if (type == null) {
			if (sun.type != null)
				return false;
		} else if (!type.equals(sun.type))
			return false;
		if (countOfPlanet != sun.countOfPlanet)
			return false;
		return true;
	}

	public String toString() {
		return getClass().getName() + " {type: " + type + ",	countOfPlanet = " + countOfPlanet + "}";
	}
}
