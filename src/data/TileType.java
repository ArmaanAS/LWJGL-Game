package data;

public enum TileType {
	
	Grass("Grass.png", true), Dirt("Dirt.png", false), Water("Water.png", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String texName, boolean buildable) {
		this.buildable = buildable;
		textureName = texName;
	}
}
