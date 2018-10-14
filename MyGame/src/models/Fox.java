package models;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Fox {

	private Box fox;

	public Fox() {
		this.fox = new Box(10, 10, 10);
		this.fox.setTranslateY(-20);
		fox.setMaterial(new PhongMaterial(Color.ORANGE));
	}

	public Box getFox() {
		return this.fox;
	}

	public double x() {
		return fox.getLayoutBounds().getMinX();
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

	/* Calculate x-area of fox */

	public double getLeftSideArea() {

		return this.getXPosition() + fox.getLayoutBounds().getMinX();
	}

	public double getRightSideArea() {
		return this.getXPosition() +fox.getLayoutBounds().getMaxX();
	}

	/* Calculate z-area of fox */

	public double getFrontSideArea() {
		return this.getZPosition() + 5;
	}

	public double getBackSideArea() {
		return this.getZPosition() - 5;
	}


}
