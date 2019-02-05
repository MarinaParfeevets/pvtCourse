package core;

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
		final int prime = 31;
		return (int) (super.hashCode()+prime * weight + (color == null ? 0 : color.hashCode()));
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
		Mars mars = (Mars) obj;
		if (color == null) {
			if (mars.color != null)
				return false;
		} else if (!color.equals(mars.color))
			return false;
		if (weight != mars.weight)
			return false;
		return true;
	}

	public String toString() {
		return getClass().getName() + " {color: " + color + ",	weight = " + weight + "}";
	}

}
