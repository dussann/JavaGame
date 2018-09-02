package models;

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
}
