package data;

import static helpers.Artist.*;

public class TileGrid {

	public Tile[][] map;
	
	public TileGrid() {
		
		map = new Tile[20][15];
		
		for (int i = 0; i < map.length; i++) {
			for (int ii = 0; ii < map[i].length; ii++) {
				map[i][ii] = new Tile(i * 64, ii * 64, 64, 64, TileType.Grass);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int ii = 0; ii < map[i].length; ii++) {
				switch(newMap[ii][i]) {
				case 0: 
					map[i][ii] = new Tile(i * 64, ii * 64, 64, 64, TileType.Grass);
					break;
				case 1: 
					map[i][ii] = new Tile(i * 64, ii * 64, 64, 64, TileType.Dirt);
					break;
				case 2: 
					map[i][ii] = new Tile(i * 64, ii * 64, 64, 64, TileType.Water);
					break;
				}
			}
		}
	}
	
	public void SetTile(int x, int y, TileType type) {
		map[x][y] = new Tile(x * 64, y * 64, 64, 64, type);
	}
	
	public Tile getTile(int x, int y) {
		try {
			return map[x][y];
		} catch (Exception e) {
			System.out.println("ERORORORORROROOROROROOR");
			return new Tile(0, 0, 64, 64, TileType.Water);
		}
	}
	
	public void Draw() {
		
		for (int i = 0; i < map.length; i++) {
			for (int ii = 0; ii < map[i].length; ii++) { 
				Tile t = map[i][ii];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
		
	}
	
}
