package models;

import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Car {
	private Box car;

	public Car(){
		this.car = new Box(20, 20, 20);
		this.car.setTranslateY(-20);
		this.car.setTranslateX(-100);
		car.setMaterial(new PhongMaterial(Color.RED));
	}

	public Box getCar (){
		return this.car;
	}

	public double getXPosition() {
		return this.car.getTranslateX();
	}

	public void setXPosition(double position) {
		this.car.setTranslateX(position);
	}

	public double getYPosition() {
		return this.car.getTranslateX();
	}

	public void setYPosition(double position) {
		this.car.setTranslateX(position);
	}

	public double getZPosition() {
		return this.car.getTranslateZ();
	}

	public void setZPosition(double position) {
		this.car.setTranslateZ(position);
	}
	public DoubleProperty getLayuoutX(){
		return this.car.layoutXProperty();
	}
}
