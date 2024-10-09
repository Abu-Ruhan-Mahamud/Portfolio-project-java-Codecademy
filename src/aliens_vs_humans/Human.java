package aliens_vs_humans;

public class Human extends Entity {
	
	private String homeCountry;
	
	public Human(String newName, String homeCountry, int number) {
		super(newName);
		this.homeCountry = homeCountry;
		setMapID("H-" + number);
	}

	public String getHomeCountry() {
		return homeCountry;
	}

	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCountry:   " + getHomeCountry();
	}
}
