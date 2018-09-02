package models;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Road {
	private Box road;

	public Road() {
		this.road = new Box(200, 10, 70);
		road.setMaterial(new PhongMaterial(Color.BLUE));
	}

	public Box getRoad() {
		return this.road;
	}

}
