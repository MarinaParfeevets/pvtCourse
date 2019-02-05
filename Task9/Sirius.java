package core;

public class Sirius extends Star {
	private boolean isVisibleFromEarth;
	private int radiation;

	public Sirius() {

	}

	public boolean isVisibleFromEarth() {
		return isVisibleFromEarth;
	}

	public void setVisibleFromEarth(boolean isVisibleFromEarth) {
		this.isVisibleFromEarth = isVisibleFromEarth;
	}

	public int getRadiation() {
		return radiation;
	}

	public void setRadiation(int radiation) {
		this.radiation = radiation;
	}

	public void printIsVisibleFromEarth() {
		String str = "Visible from Earth: ";
		System.out.println(isVisibleFromEarth ? str + "Yes" : str + "No");
	}

	public void printRadiation() {
		System.out.println("Radiation: " + radiation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return (int) (super.hashCode() + prime * radiation + (isVisibleFromEarth ? 1 : 0));
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
		Sirius sirius = (Sirius) obj;
		if (radiation != sirius.radiation)
			return false;
		if (isVisibleFromEarth != sirius.isVisibleFromEarth)
			return false;
		return true;
	}

	public String toString() {
		return getClass().getName() + " {isVisibleFromEarth:  " + isVisibleFromEarth + ",	radiation = " + radiation
				+ "}";
	}

}
