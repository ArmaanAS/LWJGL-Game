package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Clock.*;

import static helpers.Artist.*;

public class Enemy {

	private int  width, height, health;
	private float speed, x, y;
	private Tile startTile;
	private Texture texture;
	private boolean first = true;
	private TileGrid grid;
	private float xDir, yDir;
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed) {
		this.texture = texture;
		this.startTile = startTile;
		this.height = height;
		this.width = width;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.speed = speed;
		this.grid = grid;
	}
	
	public void Update() {
		if (first) {
			first = false;
		} else {
			Move();
			x += (Delta() + speed) * xDir;
			y += (Delta() + speed) * yDir;
			System.out.println(xDir + " " + yDir);
			if (grid.getTile((int) (x / 64), (int) (y / 64)).getType() != TileType.Dirt && !checkDirt()) {
				x -= (Delta() + speed) * xDir;
				y -= (Delta() + speed) * yDir;
				xDir = 0;
				yDir = 0;
			}
		}
	}
	
	private boolean checkDirt() {
		Tile adjTile = grid.getTile((int) (((x + 64 * xDir) / 64) + xDir), (int) (((y + 64 * yDir) / 64)));
		if (adjTile.getType() == TileType.Dirt) {
			return true;
		} else {
			System.out.println((int) (((x + 64 * xDir) / 64) + xDir) + " " + (int) (((y + 64 * yDir) / 64)));
			return false;
		}
	}
	
	private int[][] g = new int[][] {
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1}
	};
	private void Move() {
		if (xDir == 0 && yDir == 0) {
			for (int[] i : g) {
				Tile adjTile = grid.getTile((int) (x / 64) + i[0], (int) (y / 64) + i[1]);
				//System.out.println(adjTile.getType());
				if (adjTile.getType() == TileType.Dirt) {
					xDir = i[0];
					yDir = i[1];
					break;
				}
			}
		}
		
		if (xDir == 0 && yDir == 0) {
			System.out.println("STOP");
		}
	}
	
	public TileGrid getGrid() {
		return grid;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
	}
}
