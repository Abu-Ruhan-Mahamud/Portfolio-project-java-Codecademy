package aliens_vs_humans;

public class Alien extends Entity {
	
	private String homePlanet;

	public Alien(String newName, String homePlanet, int number) {
		super(newName);
		this.homePlanet = homePlanet;
		setMapID("A-" + number);
	}

	public String getHomePlanet() {
		return homePlanet;
	}

	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nPlanet:    " + getHomePlanet();
	}
	
	/* public static void main(String[] args) {
		Alien test = new Alien("Alien", "Mars", 1);
		System.out.println(test.toString());
		Alien test2 = new Alien("Alien2", "Jupiter", 2);
		System.out.println(test2.toString());
	} */	
}
