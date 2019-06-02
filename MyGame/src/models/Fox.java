package models;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Fox {

	private Box fox;

	public Fox() {
		this.fox = new Box(1, 1, 1);
		this.fox.setTranslateY(-1);
		this.fox.setTranslateZ(-5);
		fox.setMaterial(new PhongMaterial(Color.ORANGE));
	}

	public Box getFox() {
		return this.fox;
	}

	public double getXPosition() {
		return this.fox.getTranslateX();
	}

	public void setXPosition(double position) {
		this.fox.setTranslateX(position);
	}

	public double getYPosition() {
		return this.fox.getTranslateY();
	}

	public void setYPosition(double position) {
		this.fox.setTranslateY(position);
	}

	public double getZPosition() {
		return this.fox.getTranslateZ();
	}

	public void setZPosition(double position) {
		this.fox.setTranslateZ(position);
	}
}
