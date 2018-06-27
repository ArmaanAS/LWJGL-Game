package data;

import java.util.ArrayList;
import static helpers.Clock.*;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.WIDTH;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	
	public Wave(float spawnTime, Enemy enemyType) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		enemyList = new ArrayList<Enemy>();
	}
	
	public void Update() {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
			
		}
		
		for (Enemy e : enemyList) {
			if ((!(e.getY() < 0) || !(e.getY() > HEIGHT)) || (!(e.getX() < 0) || !(e.getX() > WIDTH))) {
				e.Update();
				e.Draw();
			} else {
				enemyList.remove(e);
			}
		}
	}
	
	private void Spawn() {
		if (enemyList.isEmpty()) {
			enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getGrid(),  64, 64, enemyType.getSpeed()));
		}
	}
}
