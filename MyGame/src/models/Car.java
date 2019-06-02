package models;

import java.util.Observable;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Transform;

public class Car {
	private Box car;

	public Car(){
		this.car = new Box(2, 2, 2);
		this.car.setTranslateY(-2);
		car.setMaterial(new PhongMaterial(Color.RED));
	}

	public ObservableList<Transform> getTransforms() {
		return this.car.getTransforms();
	}

	public Box getCar (){
		return this.car;
	}

	public double getXPosition() {
		return  car.getTranslateX();
	}

	public void setXPosition(double position) {
		this.car.setTranslateX(position);
	}

	public double getYPosition() {
		return this.car.getTranslateY();
	}

	public void setYPosition(double position) {
		this.car.setTranslateY(position);
	}

	public double getZPosition() {
		return this.car.getTranslateZ();
	}

	public void setZPosition(double position) {
		this.car.setTranslateZ(position);
	}
}
