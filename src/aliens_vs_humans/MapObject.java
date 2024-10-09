package aliens_vs_humans;

public class MapObject {
	
	private String entityName;
	private String mapID;
	
	public MapObject(String newName) {
		this.entityName = newName;
		mapID = null;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getMapID() {
		return mapID;
	}

	public void setMapID(String mapID) {
		this.mapID = mapID;
	}
	
	@Override
	public String toString() {
		return "ID:        " + mapID + "\nName:      " + entityName;
	}
}
