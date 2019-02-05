package core;

import java.util.Objects;

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

	public int hashCode() {
		return Objects.hashCode(radiation);
	}

	public String toString() {
		return "Sirius: {isVisibleFromEarth:  " + isVisibleFromEarth + ",	radiation = " + radiation + "}";
	}

}
