package core;

public class Task9 {

	public static void main(String[] args) {
		Sirius sirius = new Sirius();
		Sun sun = new Sun(34657, 5, "GY3", 6);
		Star star = new Star(8976, 1234);
		Planet planet = new Planet(3, false);
		Mars mars = new Mars();
		StarSystem earth = new Earth();

		sirius.setRadiation(56);
		sirius.setVisibleFromEarth(true);
		sirius.setStarSystemAge(2000000);
		sirius.setStarSystemName("XXX");

		sirius.printIsVisibleFromEarth();
		sirius.printRadiation();

		star.setStarSystemAge(1000000000);
		star.setStarSystemName("Galaktiada");
		star.printAllInfo();
		star.printStarSystemInfo();

		sun.printAllInfo();

		planet.setStarSystemAge(2878987);
		planet.setStarSystemName("FantasyWorld :)");
		planet.printAllInfo();
		planet.printStarSystemInfo();

		System.out.println(planet.hashCode());
		System.out.println(star.hashCode());
		System.out.println(sirius.hashCode());
		System.out.println(sun.hashCode());
		System.out.println(mars.hashCode());
		System.out.println(earth.hashCode());

		System.out.println(planet.toString());
		System.out.println(star.toString());
		System.out.println(sirius.toString());
		System.out.println(sun.toString());
		System.out.println(mars.toString());
		System.out.println(earth.toString());

		Sirius sirius1 = new Sirius();
		sirius1.setRadiation(56);
		sirius1.setVisibleFromEarth(true);
		sirius1.setStarSystemAge(2000000);
		sirius1.setStarSystemName("XXX");

		Sirius sirius2 = new Sirius();
		sirius2.setRadiation(5);
		sirius2.setVisibleFromEarth(false);
		sirius2.setStarSystemAge(2000000);
		sirius2.setStarSystemName("XXX");

		System.out.println(sirius.equals(sirius1));
		System.out.println(sirius.equals(sirius2));

		System.out.println(sirius.hashCode() == sirius1.hashCode() ? "Equals objects" : "Not equals");
		System.out.println(sirius.hashCode() == sirius2.hashCode() ? "Equals objects" : "Not equals");
	}

}
