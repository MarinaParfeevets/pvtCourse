package core;

public abstract class StarSystem {

	private long starSystemAge;
	private String starSystemName;

	public StarSystem() {

	}

	public long getStarSystemAge() {
		return starSystemAge;
	}

	public void setStarSystemAge(long starSystemAge) {
		this.starSystemAge = starSystemAge;
	}

	public String getStarSystemName() {
		return starSystemName;
	}

	public void setStarSystemName(String starSystemName) {
		this.starSystemName = starSystemName;
	}

	public abstract void printAllInfo();

	public abstract void printStarSystemInfo();

	public abstract int hashCode();

	public abstract String toString();

	public void printStarSystemAge() {
		System.out.println("Star System age: " + starSystemAge);
	}

	public void printStarSystemName() {
		System.out.println("Star system name: " + starSystemName);
	}

}
